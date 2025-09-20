package com.hbk.examples.FactoryMethodDemo.demo_1;

public class FactoryMethod {
    public static void main(String[] args) {
        final ProductOrderCreator creator = new ProductOrderCreatorImpl();
        creator.orderProduct("Book FREE!", 1);
        creator.orderProduct("Computer", 2);
    }
}
