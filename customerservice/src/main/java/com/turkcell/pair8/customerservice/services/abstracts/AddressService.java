package com.turkcell.pair8.customerservice.services.abstracts;

import com.turkcell.pair8.customerservice.services.dtos.address.request.AddAddressRequest;
import com.turkcell.pair8.customerservice.services.dtos.address.request.UpdateAddressRequest;

public interface AddressService {
    AddAddressRequest add(AddAddressRequest request);
    void delete(int id);
    void update(UpdateAddressRequest request);
}