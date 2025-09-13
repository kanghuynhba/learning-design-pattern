package com.hbk.example.AbstractFactoryDemo.demo_1.factory;

import com.hbk.example.AbstractFactoryDemo.demo_1.Graphics; 
import com.hbk.example.AbstractFactoryDemo.demo_1.WindowsGraphics; 

public class WindowsGraphicsFactory implements GraphicsFactory {
    @Override
    public Graphics newGraphics() {
        return new WindowsGraphics();
    }
}
