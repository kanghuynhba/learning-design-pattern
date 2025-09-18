package com.hbk.book_market.repository.impl;

import com.hbk.book_market.entity.Author;
import com.hbk.book_market.entity.Category;
import com.hbk.book_market.entity.Book;
import com.hbk.book_market.repository.DatabaseContext;
import com.hbk.book_market.repository.Repository;

public class DatabaseContextImpl implements DatabaseContext {
    @SuppressWarnings("unchecked")
    @Override
    public <E, R extends Repository<E>> R newRepository(Class<E> entityType) {
        if(entityType==Author.class) {
            return (R) new AuthorRepositoryImpl();
        }
        if(entityType==Category.class) {
            return (R) new CategoryRepositoryImpl();
        }
        if(entityType==Book.class) {
            return (R) new BookRepositoryImpl();
        }
        throw new IllegalArgumentException("there is no repository for" + entityType.getName());
    }
}
