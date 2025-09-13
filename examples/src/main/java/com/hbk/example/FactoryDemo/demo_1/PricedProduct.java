package com.hbk.example.FactoryDemo.demo_1;

public class PricedProduct extends Product {
    @Override
    public long order(long amount) {
        return getPrice() * amount;
    }
}
