package genspark.john_manuel.repository;

import genspark.john_manuel.model.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartModel, Integer> {
    /*Extending JpaRepository here allows me to skip writing a lot of boilerplate
    * code like, Find(), FindAll(), Count() and, many other commonly used methods.
    */

    List<CartModel> findAllByUserIdOrderByCreatedDateDesc(Integer userId);
    
}
