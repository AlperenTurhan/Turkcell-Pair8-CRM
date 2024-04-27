package com.turkcell.pair8.productservice.services.dtos.product.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchProductResponse {
    private String productID;
    private String name;
    private String description;
    private float unitPrice;
    private int stock;
    private Long sellerId;
    private Set<Long> categoryIdList;
}
