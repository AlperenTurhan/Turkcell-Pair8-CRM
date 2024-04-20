package com.turkcell.pair8.customerservice.services.mappers;

import com.turkcell.pair8.customerservice.entities.Account;
import com.turkcell.pair8.customerservice.services.dtos.account.request.AddAccountRequest;
import com.turkcell.pair8.customerservice.services.dtos.account.request.UpdateAccountRequest;
import com.turkcell.pair8.customerservice.services.dtos.account.response.AddAccountResponse;
import com.turkcell.pair8.customerservice.services.dtos.account.response.GetAllAccountResponse;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    Account accountFromAddRequest(AddAccountRequest request);
    GetAllAccountResponse dtoFromGetAllRequest(Account account);
    void updateAccountFromRequest(UpdateAccountRequest request, @MappingTarget Account account);
    AddAccountResponse responseFromAddRequest(Account account);
}