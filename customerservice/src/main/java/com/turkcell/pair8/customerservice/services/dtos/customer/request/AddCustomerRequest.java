package com.turkcell.pair8.customerservice.services.dtos.customer.request;

import com.turkcell.pair8.core.services.constants.Messages;
import com.turkcell.pair8.customerservice.entities.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    @Length(min = 3, max = 50, message = Messages.ValidationErrors.VALIDATION_LENGTH)
    private String firstName;

    private String middleName;

    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    private String lastName;

    @NotNull(message = Messages.ValidationErrors.VALIDATION_NOT_NULL)
    @Past(message = Messages.ValidationErrors.VALIDATION_PAST)
    private LocalDate birthDate;

    @NotNull(message = Messages.ValidationErrors.VALIDATION_NOT_NULL)
    private Gender gender;

    private String fatherName;

    private String motherName;

    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    private String nationalityID;
}