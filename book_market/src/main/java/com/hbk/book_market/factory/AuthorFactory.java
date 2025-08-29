package com.hbk.book_market.factory;

import com.hbk.book_market.entity.Author;
import com.hbk.book_market.builder.AuthorBuilder;

public interface AuthorFactory {
    Author newAuthor(String name);
    AuthorBuilder newAuthorBuilder();
}
