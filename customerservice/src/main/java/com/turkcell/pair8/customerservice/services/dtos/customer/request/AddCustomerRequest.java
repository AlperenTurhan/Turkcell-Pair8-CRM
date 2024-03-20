package com.turkcell.pair8.customerservice.services.dtos.customer.request;

import com.turkcell.pair8.customerservice.entities.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    @NotBlank
    private String firstName;
    private String middleName;
    @NotBlank
    private String lastName;
    @NotBlank
    private Date birthDate;
    @NotBlank
    private Gender gender;
    private String fatherName;
    private String motherName;
    @NotBlank
    private int nationalityID;

}
