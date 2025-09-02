package AbstractFactoryDemo.demo_1;

import AbstractFactoryDemo.demo_1.factory.impl.GraphicsFactoryImpl;
import AbstractFactoryDemo.demo_1.factory.GraphicsFactory;
import AbstractFactoryDemo.demo_1.Graphics;

public class AbstractFactory {
    public static void main(String []main) {
        final GraphicsFactory graphicsFactory=new GraphicsFactoryImpl();
        final Graphics graphics=graphicsFactory.newGraphics();
        graphics.draw();
    }
}
