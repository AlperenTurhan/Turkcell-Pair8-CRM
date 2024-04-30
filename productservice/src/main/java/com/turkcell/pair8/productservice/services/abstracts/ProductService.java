package com.turkcell.pair8.productservice.services.abstracts;

import com.turkcell.pair8.customerservice.core.paging.PageInfo;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.AddCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.SearchCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.UpdateCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.AddCustomerResponse;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.GetAllCustomerResponse;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;
import com.turkcell.pair8.productservice.entities.Product;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.AddCartRequest;
import com.turkcell.pair8.productservice.services.dtos.cart.responses.AddCartResponse;
import com.turkcell.pair8.productservice.services.dtos.product.requests.AddProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.requests.SearchProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.requests.UpdateProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.responses.AddProductResponse;
import com.turkcell.pair8.productservice.services.dtos.product.responses.SearchProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<SearchProductResponse> search(SearchProductRequest request);

    AddProductResponse add(AddProductRequest request);

    void update(UpdateProductRequest request);

    Optional<Product> getProduct(String productID);
}
