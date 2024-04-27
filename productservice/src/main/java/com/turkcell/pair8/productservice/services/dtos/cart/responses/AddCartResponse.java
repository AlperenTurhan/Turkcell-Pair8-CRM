package com.turkcell.pair8.productservice.services.dtos.cart.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCartResponse {
    private float totalAmount;

    private Long customerId;
}
