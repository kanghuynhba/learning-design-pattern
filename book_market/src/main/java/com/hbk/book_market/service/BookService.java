package com.hbk.book_market.service;

import com.hbk.book_market.BookApplication;
import com.hbk.book_market.mediator.BookAndAuthorMediator;
import com.hbk.book_market.model.BookModel;
import java.util.List;

public class BookService {
  public List<BookModel> getBooks() throws Exception {
    return BookApplication.getInstance()
        .getMediatorProvider()
        .getMediator(BookAndAuthorMediator.class)
        .getBooks();
  }
}
