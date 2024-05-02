package com.turkcell.pair8.invoiceservice.core.exception.details;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ValidationProblemDetails extends ProblemDetails {
    public ValidationProblemDetails() {
        setTitle("Validation Rule Violation");
        setErrorType("https://turkcell.com/exceptions/validation");
    }
}
