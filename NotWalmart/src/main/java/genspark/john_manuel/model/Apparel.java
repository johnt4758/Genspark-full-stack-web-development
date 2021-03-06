package genspark.john_manuel.model;

public class Apparel extends Product {

    public String type;
    public String brand;
    public String design;

    public Apparel() {}

    public String getType() {return type;}
    public String getBrand() {return brand;}
    public String getDesign() {return design;}

    public void setType( String type ) {this.type = type;}
    public void setBrand( String brand ) {this.brand = brand;}
    public void setDesign( String design ) {this.design = design;}
    
    @Override
    public double getPrice(){
        return 0;
    }
}
