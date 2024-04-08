package com.turkcell.pair8.customerservice.services.abstracts;

import com.turkcell.pair8.customerservice.core.paging.PageInfo;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.AddCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.SearchCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.UpdateCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.AddCustomerResponse;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.GetAllCustomerResponse;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<SearchCustomerResponse> search(SearchCustomerRequest request);
    List<GetAllCustomerResponse> getAll(PageInfo pageInfo);
    AddCustomerResponse add(AddCustomerRequest request);
    void delete(int id);
    void update(UpdateCustomerRequest request);
}