package com.turkcell.pair8.productservice.services.dtos.cart.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCartResponse {
    private float totalAmount;

    private Long customerId;

    private Set<Long> cartsProductsIdList;
}
