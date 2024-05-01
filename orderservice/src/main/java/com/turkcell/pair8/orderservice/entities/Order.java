package com.turkcell.pair8.orderservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(value="orders")

public class Order {
    @Id
    private String id;
    private Date orderDate;
    private String customerId;
    private double totalPrice;
    private Set<String> productIds;
}
