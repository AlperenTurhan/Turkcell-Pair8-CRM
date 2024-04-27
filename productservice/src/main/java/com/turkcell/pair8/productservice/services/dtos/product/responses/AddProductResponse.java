package com.turkcell.pair8.productservice.services.dtos.product.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductResponse {
    private String name;
    private float unitPrice;
    private int stock;
    private String description;
    private Long sellerId;
}
