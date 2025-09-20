package com.hbk.examples.AbstractFactoryDemo.demo_1.factory.impl;

import com.hbk.examples.AbstractFactoryDemo.demo_1.Graphics;
import com.hbk.examples.AbstractFactoryDemo.demo_1.factory.GraphicsFactory;
import com.hbk.examples.AbstractFactoryDemo.demo_1.factory.WindowsGraphicsFactory;
import com.hbk.examples.AbstractFactoryDemo.demo_1.factory.UbuntuGraphicsFactory;

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
