package com.turkcell.pair8.productservice.services.dtos.category.requests;

import com.turkcell.pair8.core.services.constants.Messages;
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
    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    @Length(min = 3, max = 15, message = "length")
    private String name;

    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    @Length(min = 3, max = 50, message = "length")
    private String description;
}
