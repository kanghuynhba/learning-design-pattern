package com.hbk.book_market.factory;

import com.hbk.book_market.entity.Author;

public interface AuthorFactory {
    Author newAuthor(String name);
}
