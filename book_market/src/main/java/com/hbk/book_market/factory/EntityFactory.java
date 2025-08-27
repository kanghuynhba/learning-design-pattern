package com.hbk.book_market.factory;

public interface EntityFactory {
    <E> E newEntity(Class<E> entityType, String name);
}
