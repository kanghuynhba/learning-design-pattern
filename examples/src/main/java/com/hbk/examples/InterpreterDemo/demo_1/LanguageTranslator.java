package com.hbk.examples.InterpreterDemo.demo_1;

import java.util.Map;
import java.util.HashMap;

public class LanguageTranslator {
    private final Map<LanguageType, Map<LanguageType, LanguageInterpreter>> interpreters;

    public LanguageTranslator() {
        Map<LanguageType, LanguageInterpreter> englishInterpreters=new HashMap<>(); 
        englishInterpreters.put(LanguageType.VI, new LanguageEnglishToVietnameseInterpreter());      

        Map<LanguageType, LanguageInterpreter> vietnameseInterpreters=new HashMap<>(); 
        vietnameseInterpreters.put(LanguageType.EN, new LanguageVietnameseToEnglishInterpreter());      

        interpreters=new HashMap<>();
        interpreters.put(LanguageType.EN, englishInterpreters);
        interpreters.put(LanguageType.VI, vietnameseInterpreters);
    }

    public String translate(LanguageTranslatedRequest request) {
        return interpreters
            .get(request.getInputLanguageText())
            .get(request.getOutputLanguageText())
            .interpreter(request.getText());
    };
    
    public static void main(String []args) {
        LanguageTranslator translator=new LanguageTranslator();
        String englishText="Hello";
        String translatedVietnameseText=translator.translate(
            new LanguageTranslatedRequest(
                LanguageType.EN,
                LanguageType.VI, englishText
            )
        );

        System.out.println("English text: " + englishText);
        System.out.println("Vietnamese text: " + translatedVietnameseText);

        String vietnameseText="Chao buoi sang";
        String translatedEnglishText=translator.translate(
            new LanguageTranslatedRequest(
                LanguageType.VI,
                LanguageType.EN, vietnameseText
            )
        );

        System.out.println("Vietnamese text: " + vietnameseText);
        System.out.println("English text: " + translatedEnglishText);
    }
}
