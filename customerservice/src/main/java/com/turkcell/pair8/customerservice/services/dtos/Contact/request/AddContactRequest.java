package com.turkcell.pair8.customerservice.services.dtos.Contact.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddContactRequest {
    @NotBlank
    private String email;

    private String homePhone;
    @NotBlank
    private String mobilePhone;

    private String fax;
    private Long customerId;

}
