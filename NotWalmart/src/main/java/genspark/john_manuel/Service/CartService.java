package genspark.john_manuel.Service;

import genspark.john_manuel.dto.AddDto;
import genspark.john_manuel.dto.CartDto;
import genspark.john_manuel.model.*;
import genspark.john_manuel.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public CartService(){}
    
    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }
    
    public void addToCart(AddDto addDto, Product product, User user){
        CartModel cartModel = new CartModel(product, addDto.getQuantity(), user);
        cartRepository.save(cartModel);
    }
    
    public OrderModel listCartItems(int userId){
        List<CartModel> cartModelList = cartRepository.findAllByUserIdOrderByCreatedDateDesc(userId);
        List<CartDto> cartDtoItems = new ArrayList<>();
        for(CartModel cart : cartModelList){
            CartDto cartDto = getDtoFromCart(cart);
            cartDtoItems.add(cartDto);
        }
        double totalCost = 0;
        for(CartDto cartDto : cartDtoItems){
            totalCost += (cartDto.getProduct().getPrice() * cartDto.getQuantity());
        }
        return new OrderModel(cartDtoItems, totalCost);
    }
    
    public static CartDto getDtoFromCart(CartModel cartModel){
        return new CartDto(cartModel);
    }
}
