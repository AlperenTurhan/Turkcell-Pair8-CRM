package com.turkcell.pair8.customerservice.services.dtos.address.request;


import com.turkcell.pair8.core.services.constants.Messages;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressRequest {
    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    private String city;

    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    private String street;

    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    @Min(1)
    private String houseFlatNumber;

    @NotBlank(message = Messages.ValidationErrors.VALIDATION_NOT_BLANK)
    private String addressDescription;
}