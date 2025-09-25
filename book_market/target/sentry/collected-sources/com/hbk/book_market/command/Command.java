package com.hbk.book_market.command;

public interface Command<R> {
    R execute() throws Exception;
}
