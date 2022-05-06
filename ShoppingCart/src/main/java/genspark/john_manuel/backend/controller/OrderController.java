package genspark.john_manuel.backend.controller;

import genspark.john_manuel.backend.dto.OrderProductDto;
import genspark.john_manuel.backend.models.Order;
import genspark.john_manuel.backend.models.OrderProduct;
import genspark.john_manuel.backend.service.OrderProductService;
import genspark.john_manuel.backend.service.OrderService;
import genspark.john_manuel.backend.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders") //this line for both controllers sets the URL in the database to the respective dbaddress/api/"controller name"
public class OrderController{
    
    ProductService productService;
    OrderService orderService;
    OrderProductService orderProductService;
    
    public OrderController(ProductService productService, OrderService orderService, OrderProductService orderProductService){
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }
    
    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderForm form){
        List<OrderProductDto> formObjects = form.getProductOrders();
        
        Order order = new Order();
        order = this.orderService.create(order);
        
        List<OrderProduct> orderProducts = new ArrayList<>();
        for(OrderProductDto orderObjects : formObjects){
            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(
                    orderObjects.getProduct()
                            .getId()), orderObjects.getQuantity())));
        }
        
        order.setOrderProducts(orderProducts);
        
        this.orderService.update(order);
        
        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/orders/{id}")
                .buildAndExpand(order.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);
        
        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }
    
    public static class OrderForm{
        
        private List<OrderProductDto> productOrders;
        
        public List<OrderProductDto> getProductOrders(){return productOrders;}
        
        public void setProductOrders(List<OrderProductDto> productOrders){this.productOrders = productOrders;}
    }
}
