package genspark.john_manuel.backend.service;

import genspark.john_manuel.backend.models.Order;
import genspark.john_manuel.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    
    OrderRepository orderRepository;
    
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    
    @Override
    public Iterable<Order> getAllOrders(){
        return this.orderRepository.findAll();
    }
    
    @Override
    public Order create(Order order){
        order.setDateCreated(LocalDate.now());
        return this.orderRepository.save(order);
    }
    
    @Override
    public void update(Order order){
        this.orderRepository.save(order);
    }
    
//    @PostMapping
//    public ResponseEntity<Order> create(@RequestBody OrderForm form){
//        List<OrderP>
//    }
}
