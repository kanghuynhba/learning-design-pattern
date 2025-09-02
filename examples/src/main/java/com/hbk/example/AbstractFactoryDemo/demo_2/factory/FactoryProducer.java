package AbstractFactoryDemo.demo_2.factory;

public class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded) {
        if(rounded) {
            return new RoundedFactory();
        }            
        return new ShapeFactory();
    }
}
