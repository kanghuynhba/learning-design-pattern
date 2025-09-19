package com.hbk.book_market.factory.impl;

import com.hbk.book_market.entity.Author;
import com.hbk.book_market.factory.AuthorFactory;
import com.hbk.book_market.builder.AuthorBuilder;

public class AuthorFactoryImpl implements AuthorFactory {
    @Override
    public Author newAuthor(String name) {
        final Author author = new Author();
        author.setName(name);
        return author;
    } 
    
    @Override
    public AuthorBuilder newAuthorBuilder() {
        return new AuthorBuilder();
    }
}
