package com.turkcell.pair8.productservice.services.abstracts;

import com.turkcell.pair8.productservice.entities.Product;
import com.turkcell.pair8.productservice.services.dtos.product.requests.AddProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.requests.SearchProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.requests.UpdateProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.responses.AddProductResponse;
import com.turkcell.pair8.productservice.services.dtos.product.responses.SearchProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    SearchProductResponse getAll(SearchProductRequest request);
    AddProductResponse add(AddProductRequest request);

    void update(UpdateProductRequest request);

    Optional<Product> getProduct(String productID);
}
