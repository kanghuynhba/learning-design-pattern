package FactoryPattern;

public class ShapeFactory {
    Shape getShape(String input) {
        switch(input) {
            case "CIRCLE":
                return new Circle();
            case "RETANGLE":
                return new Retangle();
            case "SQUARE":
                return new Square();
            default:
                return null;
        }
    }
}
