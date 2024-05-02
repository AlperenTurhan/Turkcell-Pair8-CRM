package com.turkcell.pair8.invoiceservice.core.exception.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDetails {
    private String title;
    private String detail;
    private String errorType;
}
