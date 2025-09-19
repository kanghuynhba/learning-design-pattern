package com.hbk.book_market.interpreter;

public interface Interpreter<T>{
    String translate(T input);
}
