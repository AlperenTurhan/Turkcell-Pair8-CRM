package com.turkcell.pair8.customerservice.core.services.abstracts;

public interface MessageService {
    String getMessage(String key);
    String getMessageWithArgs(String key, Object... args);
}