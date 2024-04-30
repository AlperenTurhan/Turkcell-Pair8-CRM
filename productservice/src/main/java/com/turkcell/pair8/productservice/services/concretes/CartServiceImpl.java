package com.turkcell.pair8.productservice.services.concretes;

import com.turkcell.pair8.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair8.customerservice.core.services.constants.Messages;
import com.turkcell.pair8.customerservice.entities.Address;
import com.turkcell.pair8.customerservice.entities.Contact;
import com.turkcell.pair8.customerservice.services.dtos.Contact.request.AddContactRequest;
import com.turkcell.pair8.customerservice.services.dtos.Contact.request.UpdateContactRequest;
import com.turkcell.pair8.customerservice.services.dtos.address.request.UpdateAddressRequest;
import com.turkcell.pair8.customerservice.services.mappers.AddressMapper;
import com.turkcell.pair8.customerservice.services.mappers.ContactMapper;
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
    //TODO: MESSAGES

    }
    public AddCartRequest add(AddCartRequest request){
        Cart cart = CartMapper.INSTANCE.addCartRequest(request);
        cartRepository.save(cart);
        return request;
    }
}

