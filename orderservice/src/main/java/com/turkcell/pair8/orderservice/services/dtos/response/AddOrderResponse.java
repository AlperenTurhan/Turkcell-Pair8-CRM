package com.turkcell.pair8.orderservice.services.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderResponse {
    private Date orderDate;
    private String customerId;
    private double totalPrice;
    private Set<String> productIds;
}
