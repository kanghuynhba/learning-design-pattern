package com.hbk.examples.MediatorDemo.demo_1.mediator;

import lombok.Data;

@Data
public class Note {
    private String name;
    private String text;

    public Note() {
        name="New Note";
    }

    @Override
    public String toString() {
        return name;
    }
}
