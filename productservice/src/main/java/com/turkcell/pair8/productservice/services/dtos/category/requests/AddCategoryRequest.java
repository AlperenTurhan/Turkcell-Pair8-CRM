package com.turkcell.pair8.productservice.services.dtos.category.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddCategoryRequest {
    // TODO: message service core a çekilecek
    @NotBlank(message = "not_blank")
    @Length(min = 3, max = 15, message = "length")
    private String name;

    @NotBlank(message = "not_blank")
    @Length(min = 3, max = 50, message = "length")
    private String description;
}
