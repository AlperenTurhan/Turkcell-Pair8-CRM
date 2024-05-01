package com.turkcell.pair8.invoiceservice.core.service.abstracts;

public interface MessageService {
    String getMessage(String key);
    String getMessageWithArgs(String key, Object... args);
}