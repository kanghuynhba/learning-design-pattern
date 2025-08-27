package FactoryDemo;

public class Factory {
    public Product newProduct(String name, long price) {
        final Product product;
        if(price==0) {
            product=new FreeProduct();
            product.setName(name+ " FREE");
        } else {
            product=new PricedProduct();
            product.setName(name);
            product.setPrice(price);
        }
        return product;
    }
    public static void main(String[] args) {
        final Factory factory = new Factory();
        final Product freeProduct = factory.newProduct("Book", 0);
        System.out.println(freeProduct.getName() + " - Price: " + freeProduct.getPrice());

        final Product pricedProduct = factory.newProduct("Computer", 1000);
        System.out.println(pricedProduct.getName() + " - Price: " + pricedProduct.getPrice());
    }
}


