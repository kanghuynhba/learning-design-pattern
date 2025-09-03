package com.hbk.book_market.handler;

// Defines a handler for operations that performs actions on an input of type T
// and return the same inputs unchangej.
public interface VoidHandler<T> extends Handler<T, T> {
    @Override
    default T handle(T input) throws Exception {
        voidHandler(input);
        return input;
    }

    void voidHandler(T input) throws Exception;
}
