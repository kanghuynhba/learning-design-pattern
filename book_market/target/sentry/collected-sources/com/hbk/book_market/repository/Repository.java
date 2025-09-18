package com.hbk.book_market.repository;

public interface Repository<T> {
    void save(T entity) throws Exception;
}
