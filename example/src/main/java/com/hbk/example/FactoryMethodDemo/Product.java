package FactoryMethodDemo;

import lombok.Data;

@Data
public abstract class Product {
    private String name;
    private long price;

    public abstract long order(long amount);
}
