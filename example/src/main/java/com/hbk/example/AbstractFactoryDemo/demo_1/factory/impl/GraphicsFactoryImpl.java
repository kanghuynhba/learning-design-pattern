package AbstractFactoryDemo.demo_1.factory.impl;

import AbstractFactoryDemo.demo_1.Graphics;
import AbstractFactoryDemo.demo_1.factory.GraphicsFactory;
import AbstractFactoryDemo.demo_1.factory.WindowsGraphicsFactory;
import AbstractFactoryDemo.demo_1.factory.UbuntuGraphicsFactory;

public class GraphicsFactoryImpl implements GraphicsFactory {
    private final GraphicsFactory windowsGraphicsFactory = new WindowsGraphicsFactory();
    private final GraphicsFactory ubuntuGraphicsFactory = new UbuntuGraphicsFactory();
    @Override
    public Graphics newGraphics() {
        final String os=System.getProperty("os.name"); 
        if("windows".equals(os)) {
            return windowsGraphicsFactory.newGraphics();
        }
        return ubuntuGraphicsFactory.newGraphics();
    }
}
