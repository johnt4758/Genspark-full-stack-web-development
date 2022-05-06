package genspark.john_manuel.backend.repository;

import genspark.john_manuel.backend.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long>{
}
