package com.hbk.book_market.handler;

import com.tvd12.ezyhttp.core.response.ResponseEntity;

import java.util.List;
import java.util.ArrayList;

public class ChainOfResponsibility {
    private final List<Handler> handlers=new ArrayList<>();
    private static final GlobalExceptionHandler GLOBAL_EXCEPTION_HANDLER=
        new GlobalExceptionHandler();

    public ChainOfResponsibility addFirstVoidHandler(FirstVoidHandler handler) {
        handlers.add(handler);
        return this;
    }

    public <R> ChainOfResponsibility addFirstHandle(FirstHandler<R> handler) {
        handlers.add(handler);
        return this;
    }

    public <T, R> ChainOfResponsibility addHandle(Handler<T, R> handler) {
        handlers.add(handler);
        return this;
    }

    public <T> ChainOfResponsibility addVoidHandle(VoidHandler<T> handler) {
        handlers.add(handler);
        return this;
    }

    public ResponseEntity handle() {
        try {
            Object result=null;
            for(Handler handler : handlers) {
                result=handler.handle(result);
            }

            if(result instanceof ResponseEntity) {
                return (ResponseEntity) result;
            } else {
                return ResponseEntity.ok(result);
            }
        } catch (Exception e) {
            return GLOBAL_EXCEPTION_HANDLER.handle(e);
        }
    }
}
