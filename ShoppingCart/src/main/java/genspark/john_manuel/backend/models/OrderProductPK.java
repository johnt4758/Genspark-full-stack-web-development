package genspark.john_manuel.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class OrderProductPK implements Serializable{
    
    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    
    public Order getOrder(){return order;}
    public Product getProduct(){return product;}
    
    public void setOrder(Order order){this.order = order;}
    public void setProduct(Product product){this.product = product;
    }
}
