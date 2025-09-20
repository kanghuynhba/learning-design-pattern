package com.hbk.examples.AbstractFactoryDemo.demo_2.factory;

import com.hbk.examples.AbstractFactoryDemo.demo_2.Shape;

public abstract class AbstractFactory {
    public abstract Shape getShape(String shapeType);
}
