package com.hbk.book_market.repository.impl;

import com.hbk.book_market.BookApplication;
import com.hbk.book_market.entity.Category;
import com.hbk.book_market.repository.CategoryRepository;
import com.hbk.book_market.command.SaveCommand;

public class CategoryRepositoryImpl implements CategoryRepository {
    @Override
    public void save(Category category) throws Exception {
        final SaveCommand<Category> command=BookApplication
            .getInstance()
            .getCommandProvider()
            .provide(SaveCommand.class);
            command.entity(category).execute();
    }
}



