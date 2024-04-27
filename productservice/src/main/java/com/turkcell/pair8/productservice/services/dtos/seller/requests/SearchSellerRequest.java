package com.turkcell.pair8.productservice.services.dtos.seller.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchSellerRequest {
    private String name;
    private String sellerID;
    private String phoneNumber;
    private String taxNumber;
}
