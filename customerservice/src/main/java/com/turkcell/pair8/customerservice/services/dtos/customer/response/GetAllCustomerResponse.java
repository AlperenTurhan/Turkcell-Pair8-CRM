package com.turkcell.pair8.customerservice.services.dtos.customer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomerResponse {
    private String nationalityID;
    private String customerID;
    private String accountNumber;
    private String gsmNumber;
    private String firstName;
    private String lastName;
    private String orderNumber;
}