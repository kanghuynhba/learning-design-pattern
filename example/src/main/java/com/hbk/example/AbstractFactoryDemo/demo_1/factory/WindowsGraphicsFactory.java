package AbstractFactoryDemo.demo_1.factory;

import AbstractFactoryDemo.demo_1.Graphics; 
import AbstractFactoryDemo.demo_1.WindowsGraphics; 

public class WindowsGraphicsFactory implements GraphicsFactory {
    @Override
    public Graphics newGraphics() {
        return new WindowsGraphics();
    }
}
