package com.hbk.book_market.controller;

import com.tvd12.ezyhttp.core.exception.HttpBadRequestException;
import com.tvd12.ezyhttp.core.response.ResponseEntity;
import com.tvd12.ezyhttp.server.core.annotation.Controller;
import com.tvd12.ezyhttp.server.core.annotation.DoPost;
import com.tvd12.ezyhttp.server.core.annotation.RequestBody;

import com.hbk.book_market.BookApplication;
import com.hbk.book_market.builder.AuthorBuilder;
import com.hbk.book_market.entity.Author;
import com.hbk.book_market.factory.EntityFactory;
import com.hbk.book_market.repository.AuthorRepository;
import com.hbk.book_market.handler.ChainOfResponsibility;
import com.hbk.book_market.request.AddAuthorRequest;
import com.hbk.book_market.response.AddAuthorResponse;

import java.util.Map;
import java.util.HashMap;

import static com.tvd12.ezyfox.io.EzyStrings.isBlank;

@Controller("/api/v1")
public class ApiAuthorController {
    private final BookApplication bookApplication =
        BookApplication.getInstance();
    private final EntityFactory entityFactory =
        bookApplication.getEntityFactory();
    private final AuthorRepository authorRepository =
        bookApplication
            .getDatabaseContext()
            .newRepository(Author.class);

   @DoPost("/authors/add")
   public ResponseEntity addAuthor(
        @RequestBody AddAuthorRequest request
    ) {
        return new ChainOfResponsibility()
            .addFirstVoidHandler(() -> {
                final Map<String, String> errors=new HashMap<>();
                if(isBlank(request.getAuthorName())) {
                    errors.put("authorName", "required");
                }
                if(!errors.isEmpty()) {
                    throw new HttpBadRequestException(errors);
                }
            })
            .addFirstHandle(() -> {
                final Author author = entityFactory
                    .newEntityBuilder(AuthorBuilder.class)
                    .name(request.getAuthorName())
                    .build();
                authorRepository.save(author);
                return new AddAuthorResponse(author.getId());
            })
            .handle();
    }
}
