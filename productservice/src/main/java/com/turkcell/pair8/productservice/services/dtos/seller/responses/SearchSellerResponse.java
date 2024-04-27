package com.turkcell.pair8.productservice.services.dtos.seller.responses;

import com.turkcell.pair8.productservice.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchSellerResponse {
    private String sellerID;
    private String name;
    private String email;
    private String taxNumber;
    private String phoneNumber;
    private List<Product> products;
}
