package genspark.john_manuel.backend.service;

import genspark.john_manuel.backend.models.Product;
import genspark.john_manuel.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    
    ProductRepository productRepository;
    
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    
    @Override
    public Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }
    
    @Override
    public Product getProduct(long id){
        return productRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " does not exist"));
    }
    
    @Override
    public Product save(Product product){
        return productRepository.save(product);
    }
    
}
