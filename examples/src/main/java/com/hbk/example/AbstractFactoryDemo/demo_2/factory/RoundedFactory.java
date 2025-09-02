package AbstractFactoryDemo.demo_2.factory;

import AbstractFactoryDemo.demo_2.Shape;
import AbstractFactoryDemo.demo_2.RoundedSquare;
import AbstractFactoryDemo.demo_2.RoundedRectangle;

public class RoundedFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("SQUARE")) {
            return new RoundedSquare();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new RoundedRectangle();
        }             
        return null;
    }
}
