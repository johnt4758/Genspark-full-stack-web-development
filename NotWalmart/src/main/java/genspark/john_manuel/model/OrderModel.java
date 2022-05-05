package genspark.john_manuel.model;

import genspark.john_manuel.dto.CartDto;

import java.util.List;

public class OrderModel {

    private List<CartDto> cartItems;
    private double totalCost;

    public OrderModel(List<CartDto> cartItems, double totalCost){
        this.cartItems = cartItems;
        this.totalCost = totalCost;
    }

    public List<CartDto> getCartItems(){return cartItems;}
    public double getTotalCost(){return totalCost;}

    public void setCartItems(List<CartDto> cartItems){this.cartItems = cartItems;}
    public void setTotalCost(double totalCost){this.totalCost = totalCost;}
}
