package com.turkcell.pair8.productservice.services.abstracts;

import com.turkcell.pair8.customerservice.services.dtos.customer.request.AddCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.UpdateCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.AddCustomerResponse;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.AddCartRequest;
import com.turkcell.pair8.productservice.services.dtos.cart.requests.UpdateCartRequest;
import com.turkcell.pair8.productservice.services.dtos.cart.responses.AddCartResponse;
import com.turkcell.pair8.productservice.services.dtos.category.requests.AddCategoryRequest;
import com.turkcell.pair8.productservice.services.dtos.category.requests.UpdateCategoryRequest;
import com.turkcell.pair8.productservice.services.dtos.category.responses.AddCategoryResponse;

public interface CategoryService {
    AddCategoryResponse add(AddCategoryRequest request);
    void update(UpdateCategoryRequest request);
}
