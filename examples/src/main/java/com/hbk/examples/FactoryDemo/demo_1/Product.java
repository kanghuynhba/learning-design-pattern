package com.hbk.examples.FactoryDemo.demo_1;

public abstract class Product {
    private String name;
    private long price;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public abstract long order(long amount);

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }
}
