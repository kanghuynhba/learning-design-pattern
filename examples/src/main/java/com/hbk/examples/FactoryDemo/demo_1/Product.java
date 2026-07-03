package com.hbk.examples.FactoryDemo.demo_1;

import lombok.Data;

@Data
public abstract class Product {
    private String name;
    private long price=0;
    public abstract long order(long amount);
}
