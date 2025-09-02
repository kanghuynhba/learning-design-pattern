package AbstractFactoryDemo.demo_2.factory;

import AbstractFactoryDemo.demo_2.Shape;
import AbstractFactoryDemo.demo_2.Square;
import AbstractFactoryDemo.demo_2.Rectangle;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }             
        return null;
    }
}
