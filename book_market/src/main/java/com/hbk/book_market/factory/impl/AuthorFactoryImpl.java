package com.hbk.book_market.factory.impl;

import com.hbk.book_market.entity.Author;
import com.hbk.book_market.factory.AuthorFactory;

public class AuthorFactoryImpl implements AuthorFactory {
    @Override
    public Author newAuthor(String name) {
        final Author author = new Author();
        author.setName(name);
        return author;
    } 
}
