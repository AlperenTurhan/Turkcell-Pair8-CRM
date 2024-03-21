package com.turkcell.pair8.customerservice.services.mappers;

import com.turkcell.pair8.customerservice.entities.Customer;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.AddCustomerRequest;
import org.mapstruct.factory.Mappers;
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer customerFromAddRequest(AddCustomerRequest request);
}
