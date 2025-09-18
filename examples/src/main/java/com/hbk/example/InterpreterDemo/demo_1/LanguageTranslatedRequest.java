package com.hbk.example.InterpreterDemo.demo_1;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Context
@Getter
@AllArgsConstructor
public class LanguageTranslatedRequest {
    private final LanguageType inputLanguageText;
    private final LanguageType outputLanguageText;
    private final String text;
}
