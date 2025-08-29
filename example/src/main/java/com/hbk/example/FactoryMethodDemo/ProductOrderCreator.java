package FactoryMethodDemo;

import FactoryMethodDemo.Product;

// Abstract Class Creator
public abstract class ProductOrderCreator {
    public void orderProduct(String productName, int amount) {
        final Product product=newProduct(productName);
        storeOrder(product, amount);
    }

    protected abstract Product newProduct(String productName);

    private void storeOrder(Product product, int amount) {};
}
