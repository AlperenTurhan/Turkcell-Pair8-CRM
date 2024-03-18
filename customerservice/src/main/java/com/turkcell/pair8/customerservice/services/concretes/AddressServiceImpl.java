package com.turkcell.pair8.customerservice.services.concretes;

import com.turkcell.pair8.customerservice.repositories.AddressRepository;
import com.turkcell.pair8.customerservice.services.abstracts.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository  addressRepository;
}