package com.turkcell.pair8.customerservice.services.dtos.customer.response;

import com.turkcell.pair8.customerservice.entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerResponse {
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private String fatherName;
    private String motherName;
    private int nationalityID;
}
