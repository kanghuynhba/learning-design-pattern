package com.hbk.book_market.service;

import com.hbk.book_market.BookApplication;
import com.hbk.book_market.mediator.BookAndAuthorMediator;
import com.hbk.book_market.model.AuthorModel;
import java.util.List;

public class AuthorService {
  public List<AuthorModel> getAuthors() throws Exception {
    return BookApplication.getInstance()
        .getMediatorProvider()
        .getMediator(BookAndAuthorMediator.class)
        .getAuthors();
  }
}
