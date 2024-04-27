package com.turkcell.pair8.productservice.services.dtos.product.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    // TODO: message service core a çekilecek
    @NotBlank(message = "not_blank")
    @Length(min = 3, max = 15, message = "length")
    private String name;

    @NotBlank
    @Min(0)
    private float unitPrice;

    @NotBlank
    @Min(0)
    private int stock;

    @NotBlank(message = "not_blank")
    @Length(min = 3, max = 50, message = "length")
    private String description;

    private Long sellerId;
}
