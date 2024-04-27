package com.turkcell.pair8.productservice.services.dtos.category.responses;

import com.turkcell.pair8.productservice.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCategoryResponse {
    private String name;
    private String description;
    private Set<Product> products;
}
