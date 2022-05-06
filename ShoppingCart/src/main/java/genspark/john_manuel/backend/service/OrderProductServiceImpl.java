package genspark.john_manuel.backend.service;

import genspark.john_manuel.backend.models.OrderProduct;
import genspark.john_manuel.backend.repository.OrderProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService{
    
    private final OrderProductRepository orderProductRepository;
    
    public OrderProductServiceImpl(OrderProductRepository orderProductRepository){
        this.orderProductRepository = orderProductRepository;
    }
    
    @Override
    public OrderProduct create(OrderProduct orderProduct){
        return this.orderProductRepository.save(orderProduct);
    }
}
