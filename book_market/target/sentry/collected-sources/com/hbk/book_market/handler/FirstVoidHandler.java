package com.hbk.book_market.handler;

// Defines a handler for operations that perform actions
// without requiring input or producing output.
public interface FirstVoidHandler extends Handler<Void, Void> {
    @Override
    default Void handle(Void input) throws Exception {
        voidHandle();
        return null;
    }

    void voidHandle() throws Exception;
}
