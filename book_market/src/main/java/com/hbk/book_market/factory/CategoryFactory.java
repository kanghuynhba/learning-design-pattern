 package com.hbk.book_market.factory;

import com.hbk.book_market.entity.Category;

public interface CategoryFactory {
    Category newCategory(String name);
}
