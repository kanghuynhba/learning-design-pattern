package AbstractFactoryDemo.factory.impl;

import AbstractFactoryDemo.Graphics;
import AbstractFactoryDemo.factory.GraphicsFactory;
import AbstractFactoryDemo.factory.WindowsGraphicsFactory;
import AbstractFactoryDemo.factory.UbuntuGraphicsFactory;

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
