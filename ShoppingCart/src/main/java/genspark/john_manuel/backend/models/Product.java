package genspark.john_manuel.backend.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Product{
    
    @Id
    @GeneratedValue
    private long id;
    
    @NotNull(message = "Product name is required")
    @Basic(optional = false)
    private String name;
    
    private Double price;
    
    private String pictureUrl;
    
    public Product(){}
    
    public Product(long id, String name, Double price, String pictureUrl){
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }
    
    public long getId(){return id;}
    public String getName(){return name;}
    public Double getPrice(){return price;}
    public String getPictureUrl(){return pictureUrl;}
    
    public void setId(long id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setPrice(Double price){this.price = price;}
    public void setPictureUrl(String pictureUrl){this.pictureUrl = pictureUrl;}
}
