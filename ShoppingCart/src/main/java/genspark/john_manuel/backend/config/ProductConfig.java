package genspark.john_manuel.backend.config;

import genspark.john_manuel.backend.models.Apparel;
import genspark.john_manuel.backend.models.Book;
import genspark.john_manuel.backend.models.Product;
import genspark.john_manuel.backend.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig{
    
    @Bean
    CommandLineRunner runner(ProductRepository productRepository){
        return args -> {
            Product trueClassic = new Apparel(
                    1L, "True Classic Carbon", 16.67, "", "T-Shirt", "True Classic", "Classic");
            Product shein = new Apparel(
                    2L, "Graphic Drop Shoulder", 12.00, "", "Oversized Tee", "SHEIN", "Oversize");
            Product vuori = new Apparel(
                    3L, "Strato Slim", 44.00, "", "Crewneck Tech T-Shirt", "vuori", "Classic");
            Product insignia = new Book(
                    4L, "Insignia", 24.00, "", "Sci-Fi", "S. J. Kincaid", 2013);
            Product vortex = new Book(
                    4L, "Vortex", 24.00, "", "Sci-Fi", "S. J. Kincaid", 2014);
            Product catalyst = new Book(
                    4L, "Catalyst", 24.00, "", "Sci-Fi", "S. J. Kincaid", 2015);
            
            productRepository.saveAll(List.of(trueClassic,shein,vuori,insignia,vortex,catalyst));
            //add products
            //save all products when done
        };
    }
}
