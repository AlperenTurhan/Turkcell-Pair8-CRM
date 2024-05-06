package com.turkcell.pair8.customerservice.services.dtos.contact.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetContactResponse {
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;
}
