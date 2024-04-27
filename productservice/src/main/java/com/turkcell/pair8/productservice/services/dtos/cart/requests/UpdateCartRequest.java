package com.turkcell.pair8.productservice.services.dtos.cart.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCartRequest {
    private float totalAmount;

    @NotBlank
    private Long customerId;

    private Set<Long> cartsProductsIdList;
}
