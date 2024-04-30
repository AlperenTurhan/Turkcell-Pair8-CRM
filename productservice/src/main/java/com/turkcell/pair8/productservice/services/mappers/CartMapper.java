package com.turkcell.pair8.productservice.services.mappers;

import com.turkcell.pair8.productservice.entities.Cart;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.AddCartRequest;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.UpdateCartRequest;
import com.turkcell.pair8.productservice.services.dtos.cart.responses.AddCartResponse;
import com.turkcell.pair8.productservice.services.dtos.cart.responses.UpdateCartResponse;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);
    @Mapping(source="customerId", target="customer.id")
    Cart addCartRequest(AddCartRequest request);

    Cart updateCartRequest (UpdateCartRequest request);

    AddCartResponse responseFromAddRequest (Cart cart);
    UpdateCartResponse responseFromUpdateRequest(Cart cart);
}
