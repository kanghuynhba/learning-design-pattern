package com.hbk.examples.AbstractFactoryDemo.demo_1.factory;

import com.hbk.examples.AbstractFactoryDemo.demo_1.Graphics; 
import com.hbk.examples.AbstractFactoryDemo.demo_1.UbuntuGraphics; 

public class UbuntuGraphicsFactory implements GraphicsFactory {
    @Override
    public Graphics newGraphics() {
        return new UbuntuGraphics();
    }
}
