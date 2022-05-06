package genspark.john_manuel.backend.dto;

import genspark.john_manuel.backend.models.Product;

public class OrderProductDto{
    
    private Product product;
    private Integer quantity;
    
    public Product getProduct(){return product;}
    public Integer getQuantity(){return quantity;}
    
    public void setProduct(Product product){this.product = product;}
    public void setQuantity(Integer quantity){this.quantity = quantity;}
}
