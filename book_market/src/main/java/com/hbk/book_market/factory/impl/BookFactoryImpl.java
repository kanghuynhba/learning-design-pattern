package com.hbk.book_market.factory.impl;

import com.hbk.book_market.entity.Book;
import com.hbk.book_market.factory.BookFactory;

public class BookFactoryImpl implements BookFactory {
    @Override
    public Book newBook(String name) {
        final Book book = new Book();
        book.setName(name);
        return book;
    } 
}
