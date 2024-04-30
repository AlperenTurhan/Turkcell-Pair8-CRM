package com.turkcell.pair8.productservice.controllers;

import com.turkcell.pair8.productservice.entities.Product;
import com.turkcell.pair8.productservice.entities.Seller;
import com.turkcell.pair8.productservice.services.abstracts.SellerService;
import com.turkcell.pair8.productservice.services.dtos.product.requests.AddProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.requests.UpdateProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.responses.AddProductResponse;
import com.turkcell.pair8.productservice.services.dtos.seller.requests.AddSellerRequest;
import com.turkcell.pair8.productservice.services.dtos.seller.requests.UpdateSellerRequest;
import com.turkcell.pair8.productservice.services.dtos.seller.responses.AddSellerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/seller")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;
    @GetMapping("getSeller")
    @ResponseStatus(HttpStatus.OK)
    Optional<Seller> getSeller(String sellerID) {
        return sellerService.getSeller(sellerID);
    }

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddSellerResponse add(@Valid @RequestBody AddSellerRequest request) {
        return sellerService.add(request);
    }

    @PutMapping("updateProduct")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateSellerRequest request) {
       sellerService.update(request);

    }
}
