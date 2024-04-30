package com.turkcell.pair8.productservice.controllers;

import com.turkcell.pair8.productservice.entities.Cart;
import com.turkcell.pair8.productservice.entities.Product;
import com.turkcell.pair8.productservice.services.abstracts.ProductService;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.AddCartRequest;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.UpdateCartRequest;
import com.turkcell.pair8.productservice.services.dtos.cart.responses.AddCartResponse;
import com.turkcell.pair8.productservice.services.dtos.product.requests.AddProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.requests.UpdateProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.responses.AddProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("getProduct")
    @ResponseStatus(HttpStatus.OK)
    Optional<Product> getProduct(String productID) {
        return productService.getProduct(productID);
    }

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddProductResponse add(@Valid @RequestBody AddProductRequest request) {
        return productService.add(request);
    }

    @PutMapping("updateProduct")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateProductRequest request) {
        productService.update(request);

    }
}
