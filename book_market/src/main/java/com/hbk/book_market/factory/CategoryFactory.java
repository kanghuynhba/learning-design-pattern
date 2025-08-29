 package com.hbk.book_market.factory;

import com.hbk.book_market.entity.Category;
import com.hbk.book_market.builder.CategoryBuilder;

public interface CategoryFactory {
    Category newCategory(String name);
    CategoryBuilder newCategoryBuilder();
}
