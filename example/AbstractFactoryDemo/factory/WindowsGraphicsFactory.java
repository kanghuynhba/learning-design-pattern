package AbstractFactoryDemo.factory;

import AbstractFactoryDemo.Graphics; 
import AbstractFactoryDemo.WindowsGraphics; 

public class WindowsGraphicsFactory implements GraphicsFactory {
    @Override
    public Graphics newGraphics() {
        return new WindowsGraphics();
    }
}
