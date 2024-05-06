package com.turkcell.pair8.productservice.controllers;

import com.turkcell.pair8.productservice.entities.Cart;
import com.turkcell.pair8.productservice.services.abstracts.CartService;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.AddCartRequest;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.UpdateCartRequest;
import com.turkcell.pair8.productservice.services.dtos.cart.responses.AddCartResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("getCart")
    @ResponseStatus(HttpStatus.OK)
    Optional<Cart> getCart(int customerId) {
        return cartService.getCart(customerId);
    }

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddCartResponse add(@Valid @RequestBody AddCartRequest request) {
        return cartService.add(request);
    }

    @PutMapping("updateCart")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateCartRequest request) {
        cartService.update(request);

    }
}