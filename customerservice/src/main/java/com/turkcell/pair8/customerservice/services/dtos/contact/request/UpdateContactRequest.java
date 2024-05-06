package com.turkcell.pair8.customerservice.services.dtos.contact.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContactRequest {
    @NotBlank
    private String email;

    private String homePhone;

    @NotBlank
    private String mobilePhone;


    private String fax;
    private int customerId;
}
