package AbstractFactoryDemo.demo_1.factory;

import AbstractFactoryDemo.demo_1.Graphics; 
import AbstractFactoryDemo.demo_1.UbuntuGraphics; 

public class UbuntuGraphicsFactory implements GraphicsFactory {
    @Override
    public Graphics newGraphics() {
        return new UbuntuGraphics();
    }
}
