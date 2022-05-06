package genspark.john_manuel.backend.service;

import genspark.john_manuel.backend.models.Product;

public interface ProductService{
    
    Iterable<Product> getAllProducts();
    Product getProduct(long id);
    
    Product save(Product product);
}
