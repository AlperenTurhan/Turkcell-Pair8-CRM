package com.turkcell.pair8.customerservice.services.abstracts;

import com.turkcell.pair8.customerservice.services.dtos.address.request.UpdateAddressRequest;

public interface AddressService {
    void update(UpdateAddressRequest request);
}