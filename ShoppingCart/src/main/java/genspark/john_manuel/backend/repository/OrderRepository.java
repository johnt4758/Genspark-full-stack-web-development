package genspark.john_manuel.backend.repository;

import genspark.john_manuel.backend.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
