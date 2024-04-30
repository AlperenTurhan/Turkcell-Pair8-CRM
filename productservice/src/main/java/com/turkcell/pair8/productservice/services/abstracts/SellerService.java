package com.turkcell.pair8.productservice.services.abstracts;

import com.turkcell.pair8.productservice.entities.Product;
import com.turkcell.pair8.productservice.entities.Seller;
import com.turkcell.pair8.productservice.services.dtos.product.requests.AddProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.requests.SearchProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.requests.UpdateProductRequest;
import com.turkcell.pair8.productservice.services.dtos.product.responses.AddProductResponse;
import com.turkcell.pair8.productservice.services.dtos.product.responses.SearchProductResponse;
import com.turkcell.pair8.productservice.services.dtos.seller.requests.AddSellerRequest;
import com.turkcell.pair8.productservice.services.dtos.seller.requests.SearchSellerRequest;
import com.turkcell.pair8.productservice.services.dtos.seller.requests.UpdateSellerRequest;
import com.turkcell.pair8.productservice.services.dtos.seller.responses.AddSellerResponse;
import com.turkcell.pair8.productservice.services.dtos.seller.responses.SearchSellerResponse;

import java.util.List;
import java.util.Optional;

public interface SellerService {
    List<SearchSellerResponse> search(SearchSellerRequest request);

    AddSellerResponse add(AddSellerRequest request);

    void update(UpdateSellerRequest request);
    Optional<Seller> getSeller(String sellerID);
}

