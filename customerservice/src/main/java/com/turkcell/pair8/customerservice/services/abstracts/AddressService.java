package com.turkcell.pair8.customerservice.services.abstracts;

import com.turkcell.pair8.customerservice.services.dtos.address.request.AddAddressRequest;
import com.turkcell.pair8.customerservice.services.dtos.address.request.UpdateAddressRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.AddCustomerRequest;

public interface AddressService {
    void add(AddAddressRequest request);
    void delete(int id);
    void update(UpdateAddressRequest request);
}