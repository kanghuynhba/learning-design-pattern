package AbstractFactoryDemo;

public class WindowsGraphics implements Graphics {
    @Override
    public void draw() {
        System.out.println("Windows draw");
    }
}
