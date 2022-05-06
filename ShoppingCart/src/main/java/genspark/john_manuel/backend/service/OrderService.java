package genspark.john_manuel.backend.service;


import genspark.john_manuel.backend.models.Order;

public interface OrderService{
    
    Iterable<Order> getAllOrders();
    Order create(Order order);
    void update(Order order);
}
