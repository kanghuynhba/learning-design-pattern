package com.hbk.examples.FactoryDemo.demo_2;

public class ShapeFactory {
    Shape getShape(String input) {
        switch(input) {
            case "CIRCLE":
                return new Circle();
            case "RETANGLE":
                return new Rectangle();
            case "SQUARE":
                return new Square();
            default:
                return null;
        }
    }
}
