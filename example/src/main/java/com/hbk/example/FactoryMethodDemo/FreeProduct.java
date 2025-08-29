package FactoryMethodDemo;

public class FreeProduct extends Product {
    @Override
    public long order(long amount) {
        return 0; // Price is always 0 for free products
    }
}
