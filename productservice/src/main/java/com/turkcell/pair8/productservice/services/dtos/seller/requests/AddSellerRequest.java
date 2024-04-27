package com.turkcell.pair8.productservice.services.dtos.seller.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddSellerRequest {
    // TODO : messages
    @NotBlank(message = "not_blank")
    @Length(min = 3, max = 50, message = "length")
    private String name;

    @NotBlank(message = "not_blank")
    private String email;

    @NotBlank(message = "not_blank")
    private String taxNumber;

    @NotBlank(message = "not_blank")
    private String phoneNumber;
}
