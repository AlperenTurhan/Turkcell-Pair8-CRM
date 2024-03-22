package com.turkcell.pair8.customerservice.services.dtos.customer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCustomerResponse {
    private String customerID;
    private String firstName;
    private String middleName;
    private String lastName;
    private int nationalityID;
}