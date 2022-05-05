package genspark.john_manuel.dto;

import genspark.john_manuel.model.CartModel;
import genspark.john_manuel.model.Product;

import javax.validation.constraints.NotNull;

public class CartDto {

    private Integer id;
    private @NotNull Integer userId;
    private @NotNull Integer quantity;
    private @NotNull Product product;

    public CartDto(){}

    public CartDto( CartModel cartModel){
        this.setId(cartModel.getId());
        this.setUserId(cartModel.getId());
        this.setQuantity(cartModel.getQuantity());
        this.setProduct(cartModel.getProduct());
    }

    public Integer getId() {return id;}
    public Integer getUserId() {return userId;}
    public Integer getQuantity() {return quantity;}
    public Product getProduct() {return product;}

    public void setId( Integer id ) {this.id = id;}
    public void setUserId( Integer userId ) {this.userId = userId;}
    public void setQuantity( Integer quantity ) {this.quantity = quantity;}
    public void setProduct( Product product ) {this.product = product;}

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
