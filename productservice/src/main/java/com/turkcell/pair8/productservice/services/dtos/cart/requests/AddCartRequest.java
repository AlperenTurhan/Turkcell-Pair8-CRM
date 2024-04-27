package com.turkcell.pair8.productservice.services.dtos.cart.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCartRequest {
    private float totalAmount;

    @NotBlank
    private Long customerId;
}
