package com.turkcell.pair8.productservice.services.dtos.category.requests;

import com.turkcell.pair8.productservice.entities.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {
    @NotBlank(message = "not_blank")
    @Length(min = 3, max = 15, message = "length")
    private String name;

    @NotBlank(message = "not_blank")
    @Length(min = 3, max = 50, message = "length")
    private String description;

    private Set<Product> products;
}
