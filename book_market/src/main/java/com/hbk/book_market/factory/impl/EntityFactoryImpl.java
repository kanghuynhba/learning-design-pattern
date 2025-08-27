package com.hbk.book_market.factory.impl;

import com.hbk.book_market.entity.Author;
import com.hbk.book_market.entity.Category;
import com.hbk.book_market.entity.Book;
import com.hbk.book_market.factory.EntityFactory;
import com.hbk.book_market.factory.AuthorFactory;
import com.hbk.book_market.factory.CategoryFactory;
import com.hbk.book_market.factory.BookFactory;

import com.hbk.book_market.factory.impl.AuthorFactoryImpl;
import com.hbk.book_market.factory.impl.CategoryFactoryImpl;
import com.hbk.book_market.factory.impl.BookFactoryImpl;

public class EntityFactoryImpl implements EntityFactory {
    private final AuthorFactory authorFactory=new AuthorFactoryImpl();
    private final CategoryFactory categoryFactory=new CategoryFactoryImpl();
    private final BookFactory bookFactory=new BookFactoryImpl();

    @SuppressWarnings("unchecked")
    @Override
    public <E> E newEntity(Class<E> entityType, String name) {
        if(entityType==Author.class) {
            return (E) authorFactory.newAuthor(name);
        } else if(entityType==Category.class) {
            return (E) categoryFactory.newCategory(name);
        } else if(entityType==Book.class) {
            return (E) bookFactory.newBook(name);
        }
        throw new IllegalArgumentException(
            "there is no factory for: " + entityType         
        );
    } 
}
