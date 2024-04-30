package com.turkcell.pair8.productservice.services.mappers;


import com.turkcell.pair8.productservice.entities.Seller;

import com.turkcell.pair8.productservice.services.dtos.seller.requests.AddSellerRequest;
import com.turkcell.pair8.productservice.services.dtos.seller.requests.UpdateSellerRequest;
import com.turkcell.pair8.productservice.services.dtos.seller.responses.AddSellerResponse;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

public interface SellerMapper {
    SellerMapper INSTANCE = Mappers.getMapper(SellerMapper.class);
    @Mapping(source ="sellerId",target = "sellerID")
    Seller addSellerRequest(AddSellerRequest request);
    void updateSellerFromRequest(UpdateSellerRequest request, @MappingTarget Seller seller);
    AddSellerResponse responseFromAddSeller(Seller seller);
}
