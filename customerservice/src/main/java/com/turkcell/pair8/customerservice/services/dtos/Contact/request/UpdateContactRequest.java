package com.turkcell.pair8.customerservice.services.dtos.Contact.request;

import com.turkcell.pair8.customerservice.entities.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
