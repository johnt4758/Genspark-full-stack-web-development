package genspark.john_manuel.backend.models;

import javax.persistence.Entity;

@Entity
public class Apparel extends Product{
    
    private String type;
    private String brand;
    private String design;
    
    public Apparel(){}
    
    public Apparel(String type, String brand, String design){
        this.type = type;
        this.brand = brand;
        this.design = design;
    }
    
    public Apparel(long id, String name, Double price, String pictureUrl, String type, String brand, String design){
        super(id, name, price, pictureUrl);
        this.type = type;
        this.brand = brand;
        this.design = design;
    }
    
    public String getType(){return type;}
    public String getBrand(){return brand;}
    public String getDesign(){return design;}
    
    public void setType(String type){this.type = type;}
    public void setBrand(String brand){this.brand = brand;}
    public void setDesign(String design){this.design = design;}
}
