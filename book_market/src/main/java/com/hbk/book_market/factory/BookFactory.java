package com.hbk.book_market.factory;

import com.hbk.book_market.entity.Book;

public interface BookFactory {
    Book newBook(String name);
}
