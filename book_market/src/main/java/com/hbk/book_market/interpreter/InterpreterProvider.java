package com.hbk.book_market.interpreter;

import java.util.Map;
import java.util.HashMap;

public class InterpreterProvider {
    private final Map<Class<?>, Interpreter> interpreterByType;

    public InterpreterProvider() {
        interpreterByType=new HashMap<>();
        interpreterByType.put(
            AuthorCodeInterpreter.class,
            new AuthorCodeInterpreter()
        );
    }

    public <T extends Interpreter> T getInterpreter(Class<T> interpreterClass) {
        return (T)interpreterByType.get(interpreterClass);
    }
}
