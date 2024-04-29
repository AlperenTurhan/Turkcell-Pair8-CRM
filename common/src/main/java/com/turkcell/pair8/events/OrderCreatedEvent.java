package com.turkcell.pair8.events;

import java.time.LocalDateTime;

public class OrderCreatedEvent {
    private int orderId;
    private LocalDateTime orderDate;

    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(int orderId, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}