package com.turkcell.pair8.orderservice.services.dtos.request;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    private Date orderDate;
    private String customerId;
    private double totalPrice;
    private Set<String> productIds;
}
