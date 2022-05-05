package genspark.john_manuel.model;

public abstract class Product {

    int productId;
    String productName;
    float productPrice;

    public abstract double getPrice();
}
