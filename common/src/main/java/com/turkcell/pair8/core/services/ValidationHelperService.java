package com.turkcell.pair8.core.services;

import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Map;

public interface ValidationHelperService {
    Map<String, String> buildErrorDetails(List<FieldError> fieldErrors);

    String buildDetailString(Map<String, String> errorDetails);
}