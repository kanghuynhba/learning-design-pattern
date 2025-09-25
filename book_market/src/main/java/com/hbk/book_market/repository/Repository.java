package com.hbk.book_market.repository;

import com.tvd12.ezyfox.reflect.EzyGenerics;

import com.hbk.book_market.BookApplication;
import com.hbk.book_market.command.SaveCommand;
import com.hbk.book_market.command.IterableCommand;

import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;

public interface Repository<E> {
     default void save(E entity) throws Exception {
        final SaveCommand<E> command=BookApplication
            .getInstance()
            .getCommandProvider()
            .provide(SaveCommand.class);
        command.entity(entity).execute();
    }

    default void forEach(Consumer<E> consumer) throws Exception {
        final IterableCommand<E> command=BookApplication
            .getInstance().getCommandProvider()
            .provide(IterableCommand.class);
        final Iterable<E> iterable=command
            .entityType(getEntityType())
            .execute();
        for(E entity : iterable) {
            consumer.accept(entity);
        }
    }

    default List<E> forAll() throws Exception {
        final List<E> entities=new ArrayList<>();
        forEach(entities::add);
        return entities;
    }

    default Class<E> getEntityType() {
        return EzyGenerics.getGenericInterfacesArguments(
            getClass().getInterfaces()[0],
            Repository.class,
            1
        )[0];
    }
}
