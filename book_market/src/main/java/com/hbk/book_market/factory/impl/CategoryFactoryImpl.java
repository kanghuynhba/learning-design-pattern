package com.hbk.book_market.factory.impl;

import com.hbk.book_market.entity.Category;
import com.hbk.book_market.factory.CategoryFactory;

public class CategoryFactoryImpl implements CategoryFactory {
    @Override
    public Category newCategory(String name) {
        final Category category= new Category();
        category.setName(name);
        return category;
    } 
}
