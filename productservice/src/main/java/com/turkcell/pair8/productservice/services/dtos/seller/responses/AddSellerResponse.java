package com.turkcell.pair8.productservice.services.dtos.seller.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddSellerResponse {
    private String name;
    private String email;
    private String taxNumber;
    private String phoneNumber;
}
