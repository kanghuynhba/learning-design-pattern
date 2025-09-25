package com.hbk.book_market.repository.impl;

import com.hbk.book_market.BookApplication;
import com.hbk.book_market.entity.Book;
import com.hbk.book_market.repository.BookRepository;
import com.hbk.book_market.command.SaveCommand;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public void save(Book book) throws Exception {
        final SaveCommand<Book> command=BookApplication
            .getInstance()
            .getCommandProvider()
            .provide(SaveCommand.class);
            command.entity(book).execute();
    }
} 

