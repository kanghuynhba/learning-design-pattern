package com.hbk.examples.InterpreterDemo.demo_1;

import java.util.Map;
import java.util.HashMap;

// TerminalExpression
public class LanguageEnglishToVietnameseInterpreter implements LanguageInterpreter {
    private Map<String, String> dictionary=new HashMap<>();

    public LanguageEnglishToVietnameseInterpreter() {
        // you can read from database and files
        dictionary.put("Hello", "Xin chao");
        dictionary.put("good morning", "Chao buoi sang");
    }

    @Override
    public String interpreter(String input) {
        return dictionary.get(input);
    }
}
