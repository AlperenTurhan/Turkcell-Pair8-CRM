package com.turkcell.pair8.invoiceservice.core.exception.types;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}