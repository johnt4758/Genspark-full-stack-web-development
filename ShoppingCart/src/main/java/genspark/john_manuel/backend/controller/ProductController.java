package genspark.john_manuel.backend.controller;

import genspark.john_manuel.backend.models.Product;
import genspark.john_manuel.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/products")
public class ProductController{
    
    ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    
    @GetMapping(value = {"", "/"})
    public @NotNull Iterable<Product> getProducts(){
        return productService.getAllProducts();
    }
    
}
