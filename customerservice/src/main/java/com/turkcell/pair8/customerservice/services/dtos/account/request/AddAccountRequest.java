package com.turkcell.pair8.customerservice.services.dtos.account.request;

import com.turkcell.pair8.customerservice.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddAccountRequest {
    private String name;
    private String description;
    private Long addressId;
}
