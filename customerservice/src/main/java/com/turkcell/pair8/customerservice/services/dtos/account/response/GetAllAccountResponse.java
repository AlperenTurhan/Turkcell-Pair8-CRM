package com.turkcell.pair8.customerservice.services.dtos.account.response;

import com.turkcell.pair8.customerservice.entities.AccountStatus;
import com.turkcell.pair8.customerservice.entities.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAccountResponse {
    private AccountStatus status;
    private String number;
    private String name;
    private AccountType type;
}
