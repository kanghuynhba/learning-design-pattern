package com.hbk.book_market.repository.impl;

import com.hbk.book_market.BookApplication;
import com.hbk.book_market.entity.Author;
import com.hbk.book_market.repository.AuthorRepository;
import com.hbk.book_market.command.SaveCommand;

public class AuthorRepositoryImpl implements AuthorRepository {
    @Override
    public void save(Author author) throws Exception {
        final SaveCommand<Author> command=BookApplication
            .getInstance()
            .getCommandProvider()
            .provide(SaveCommand.class);
        command.entity(author).execute();
    }
}
