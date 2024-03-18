package com.turkcell.pair8.customerservice.services.dtos.customer.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCustomerResponse {
    private String customerId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String nationalityId;
}