package genspark.john_manuel.dto;

import genspark.john_manuel.model.CartModel;

import javax.validation.constraints.NotNull;

public class AddDto {

    private Integer id;
    private @NotNull Integer userId;
    private @NotNull Integer productId;
    private @NotNull Integer quantity;

    public AddDto(){}

    //constructor for adding in items raw one by one
    public AddDto(Integer id, Integer userId, Integer productId, Integer quantity){
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    //constructor for adding in items based on given cart
    public AddDto( CartModel cartModel){
        this.setId(cartModel.getId());
        this.setQuantity(cartModel.getQuantity());
    }

    public Integer getId() {return id;}
    public Integer getUserId() {return userId;}
    public Integer getProductId() {return productId;}
    public Integer getQuantity() {return quantity;}

    public void setId( Integer id ) {this.id = id;}
    public void setUserId( Integer userId ) {this.userId = userId;}
    public void setProductId( Integer productId ) {this.productId = productId;}
    public void setQuantity( Integer quantity ) {this.quantity = quantity;}
    
    @Override
    public String toString(){
        return "AddDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
