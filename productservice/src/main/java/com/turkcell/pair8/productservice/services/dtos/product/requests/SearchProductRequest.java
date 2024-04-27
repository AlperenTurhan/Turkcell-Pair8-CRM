package com.turkcell.pair8.productservice.services.dtos.product.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchProductRequest {
    private String productID;
    private String name;
    private float unitPrice;
    private int stock;
    private Long sellerId;
    private Set<Long> categoryIdList;
}
