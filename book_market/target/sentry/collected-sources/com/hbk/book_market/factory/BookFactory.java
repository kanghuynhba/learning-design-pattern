package com.hbk.book_market.factory;

import com.hbk.book_market.entity.Book;
import com.hbk.book_market.builder.BookBuilder;

public interface BookFactory {
    Book newBook(String name);
    BookBuilder newBookBuilder();
}
