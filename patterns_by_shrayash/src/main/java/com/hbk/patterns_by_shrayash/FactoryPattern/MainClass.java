package FactoryPattern;

public class MainClass {
    public static void main(String[] args) {
        ShapeFactory shapeFactoryObj=new ShapeFactory();
        Shape shapeObj=shapeFactoryObj.getShape("CIRCLE");
        Shape anotherShapeObj=shapeFactoryObj.getShape("RETANGLE");
        shapeObj.draw();
        anotherShapeObj.draw();
    }
}
