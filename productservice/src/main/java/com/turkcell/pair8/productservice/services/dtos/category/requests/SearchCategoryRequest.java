package com.turkcell.pair8.productservice.services.dtos.category.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCategoryRequest {
    private String name;
}
