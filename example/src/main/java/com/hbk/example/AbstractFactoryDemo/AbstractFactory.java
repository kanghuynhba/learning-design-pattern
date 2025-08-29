package AbstractFactoryDemo;

import AbstractFactoryDemo.factory.impl.GraphicsFactoryImpl;
import AbstractFactoryDemo.factory.GraphicsFactory;
import AbstractFactoryDemo.Graphics;

public class AbstractFactory {
    public static void main(String []main) {
        final GraphicsFactory graphicsFactory=new GraphicsFactoryImpl();
        final Graphics graphics=graphicsFactory.newGraphics();
        graphics.draw();
    }
}
