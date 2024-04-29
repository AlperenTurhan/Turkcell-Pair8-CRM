package com.turkcell.pair8.orderservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrdersController
{
    private final KafkaTemplate<String, String> kafkaTemplate;
    @GetMapping
    public int getCustomerIdByOrderId(@RequestParam String orderId)
    {
        //TODO: Mongodb'e gidip query ile çek.
        return 10;
    }

    @PostMapping
    public String addOrder()
    {
        kafkaTemplate.send("orderTopic", "New Order added");
        return "Order added";
    }
}