package AbstractFactoryDemo.factory;

import AbstractFactoryDemo.Graphics; 
import AbstractFactoryDemo.UbuntuGraphics; 

public class UbuntuGraphicsFactory implements GraphicsFactory {
    @Override
    public Graphics newGraphics() {
        return new UbuntuGraphics();
    }
}
