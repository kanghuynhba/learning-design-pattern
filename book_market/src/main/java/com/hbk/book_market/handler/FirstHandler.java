package com.hbk.book_market.handler;

// Defines a handler for operations that perform actions 
// producing output without requiring input
public interface FirstHandler<R> extends Handler<Void, R> {
    @Override
    default R handle(Void input) throws Exception {
        return firstHandle();
    }

    R firstHandle() throws Exception;
}
