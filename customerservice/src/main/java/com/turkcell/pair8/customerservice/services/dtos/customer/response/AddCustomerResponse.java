package com.turkcell.pair8.customerservice.services.dtos.customer.response;

import com.turkcell.pair8.customerservice.entities.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerResponse {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private Gender gender;
    private String fatherName;
    private String motherName;
    private int nationalityID;
}
