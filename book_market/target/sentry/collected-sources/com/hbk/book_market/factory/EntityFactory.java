package com.hbk.book_market.factory;

import com.hbk.book_market.builder.Builder;

public interface EntityFactory {
    <E> E newEntity(Class<E> entityType, String name);
    <E, B extends Builder<E>> B newEntityBuilder(Class<B> builderType); 
}
