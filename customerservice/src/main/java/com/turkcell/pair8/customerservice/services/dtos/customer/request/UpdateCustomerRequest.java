package com.turkcell.pair8.customerservice.services.dtos.customer.request;

import com.turkcell.pair8.customerservice.core.services.constants.Messages;
import com.turkcell.pair8.customerservice.entities.Gender;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    @Length(min = 3, max = 50, message = Messages.ValidationErrors.VALIDATION_LENGTH)
    private String firstName;

    private String middleName;

    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    private String lastName;

    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    private Date birthDate;

    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    private Gender gender;

    private String fatherName;

    private String motherName;

    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    @Min(0)
    private int nationalityID;
}
