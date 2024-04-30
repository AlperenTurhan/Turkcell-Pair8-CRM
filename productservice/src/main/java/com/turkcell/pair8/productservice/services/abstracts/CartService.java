package com.turkcell.pair8.productservice.services.abstracts;

import com.turkcell.pair8.customerservice.entities.Contact;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.AddCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.UpdateCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.AddCustomerResponse;
import com.turkcell.pair8.productservice.entities.Cart;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.AddCartRequest;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.UpdateCartRequest;
import com.turkcell.pair8.productservice.services.dtos.cart.responses.AddCartResponse;

import java.util.Optional;

public interface CartService {
    Optional<Cart> getCart(int customerId);
    AddCartResponse add(AddCartRequest request);

    void update(UpdateCartRequest request);
}
