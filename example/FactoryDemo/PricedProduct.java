package FactoryDemo;

public class PricedProduct extends Product {
    @Override
    public long order(long amount) {
        return getPrice() * amount;
    }
}
