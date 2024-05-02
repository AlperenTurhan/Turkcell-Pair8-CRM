package com.turkcell.pair8.customerservice.services.abstracts;

import com.pair4.paging.PageInfo;
import com.turkcell.pair8.customerservice.services.dtos.account.request.AddAccountRequest;
import com.turkcell.pair8.customerservice.services.dtos.account.request.UpdateAccountRequest;
import com.turkcell.pair8.customerservice.services.dtos.account.response.AddAccountResponse;
import com.turkcell.pair8.customerservice.services.dtos.account.response.GetAllAccountResponse;

import java.util.List;

public interface AccountService {
    List<GetAllAccountResponse> getAll(PageInfo pageInfo);
    AddAccountResponse add(AddAccountRequest request);
    void delete(int id);
    void update(UpdateAccountRequest request);
}