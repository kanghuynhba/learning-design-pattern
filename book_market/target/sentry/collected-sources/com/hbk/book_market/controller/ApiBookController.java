package com.hbk.book_market.controller;

import com.tvd12.ezyhttp.core.exception.HttpBadRequestException;
import com.tvd12.ezyhttp.core.response.ResponseEntity;
import com.tvd12.ezyhttp.server.core.annotation.Controller;
import com.tvd12.ezyhttp.server.core.annotation.DoPost;
import com.tvd12.ezyhttp.server.core.annotation.RequestBody;

import com.hbk.book_market.BookApplication;
import com.hbk.book_market.builder.BookBuilder;
import com.hbk.book_market.entity.Book;
import com.hbk.book_market.factory.EntityFactory;
import com.hbk.book_market.repository.BookRepository;
import com.hbk.book_market.handler.ChainOfResponsibility;
import com.hbk.book_market.request.AddBookRequest;
import com.hbk.book_market.response.AddBookResponse;

import java.util.Map;
import java.util.HashMap;

import static com.tvd12.ezyfox.io.EzyStrings.isBlank;

@Controller("/api/v1")
public class ApiBookController {
    private final BookApplication bookApplication =
        BookApplication.getInstance();
    private final EntityFactory entityFactory =
        bookApplication.getEntityFactory();
    private final BookRepository bookRepository =
        bookApplication
            .getDatabaseContext()
            .newRepository(Book.class);

   @DoPost("/books/add")
   public ResponseEntity addBook(
        @RequestBody AddBookRequest request
    ) {
        return new ChainOfResponsibility()
            .addFirstVoidHandler(() -> {
                final Map<String, String> errors=new HashMap<>();
                if(isBlank(request.getBookName())) {
                    errors.put("bookName", "required");
                }
                if(request.getAuthorId()<=0) {
                    errors.put("authorId", "required");
                }
                if(request.getCategoryId()<=0) {
                    errors.put("categoryId", "required");
                }
                if(!errors.isEmpty()) {
                    throw new HttpBadRequestException(errors);
                }
            })
            .addFirstHandle(() -> {
                final Book book = entityFactory
                    .newEntityBuilder(BookBuilder.class)
                    .name(request.getBookName())
                    .authorId(request.getAuthorId())
                    .categoryId(request.getCategoryId())
                    .build();
                bookRepository.save(book);
                return new AddBookResponse(book.getId());
            })
            .handle();
    }
}
