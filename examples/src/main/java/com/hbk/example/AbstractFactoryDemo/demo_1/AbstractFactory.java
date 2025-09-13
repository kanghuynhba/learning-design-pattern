package com.hbk.example.AbstractFactoryDemo.demo_1;

import com.hbk.example.AbstractFactoryDemo.demo_1.factory.impl.GraphicsFactoryImpl;
import com.hbk.example.AbstractFactoryDemo.demo_1.factory.GraphicsFactory;
import com.hbk.example.AbstractFactoryDemo.demo_1.Graphics;

public class AbstractFactory {
    public static void main(String []main) {
        final GraphicsFactory graphicsFactory=new GraphicsFactoryImpl();
        final Graphics graphics=graphicsFactory.newGraphics();
        graphics.draw();
    }
}
