package com.turkcell.pair8.productservice.services.concretes;

import com.turkcell.pair8.productservice.entities.Cart;
import com.turkcell.pair8.productservice.repositories.CartRepository;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.AddCartRequest;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.UpdateCartRequest;
import com.turkcell.pair8.productservice.services.mappers.CartMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class CartServiceImpl {
    private final CartRepository cartRepository;
    public Optional<Cart> getCart(int customerId) {
        return cartRepository.findByCustomerId(customerId);
    }


    public void update(UpdateCartRequest request) {
        Cart cart = CartMapper.INSTANCE.updateCartRequest(request);
        cartRepository.save(cart);
    }
    public AddCartRequest add(AddCartRequest request){
        Cart cart = CartMapper.INSTANCE.addCartRequest(request);
        cartRepository.save(cart);
        return request;
    }
}