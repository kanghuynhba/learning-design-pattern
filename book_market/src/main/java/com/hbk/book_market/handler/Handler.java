package com.hbk.book_market.handler;

public interface Handler<T, R> {
    R handle(T input) throws Exception;
}
