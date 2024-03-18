package com.turkcell.pair8.customerservice.core.exception.types;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}