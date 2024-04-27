package com.turkcell.pair8.productservice.services.dtos.category.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryResponse {
    private String name;
    private String description;
}