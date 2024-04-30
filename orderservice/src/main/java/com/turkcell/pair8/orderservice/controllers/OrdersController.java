package com.turkcell.pair8.orderservice.controllers;

import com.turkcell.pair8.events.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrdersController
{
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;
    @GetMapping
    public int getCustomerIdByOrderId(@RequestParam String orderId)
    {
        //TODO: Mongodb'e gidip query ile çek.
        return 10;
    }

    @PostMapping
    public String addOrder()
    {
        kafkaTemplate.send("orderTopic","NewOrderEvent", new OrderCreatedEvent(1, LocalDateTime.now()));
        return "Order added";
    }
}