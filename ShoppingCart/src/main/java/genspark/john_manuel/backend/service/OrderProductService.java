package genspark.john_manuel.backend.service;

import genspark.john_manuel.backend.models.OrderProduct;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderProductService{
    
    OrderProduct create(@NotNull(message = "products for an order cannot be null") @Valid OrderProduct orderProduct);
}
