package com.hbk.examples.InterpreterDemo.demo_1;

import java.util.Map;
import java.util.HashMap;

// TerminalExpression
public class LanguageVietnameseToEnglishInterpreter implements LanguageInterpreter {
    private Map<String, String> dictionary=new HashMap<>();

    public LanguageVietnameseToEnglishInterpreter() {
        // you can read from database and files
        dictionary.put("Xin chao", "Hello");
        dictionary.put("Chao buoi sang", "Good morning");
    }

    @Override
    public String interpreter(String input) {
        return dictionary.get(input);
    }
}
