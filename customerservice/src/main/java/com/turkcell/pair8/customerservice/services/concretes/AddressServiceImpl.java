package com.turkcell.pair8.customerservice.services.concretes;

import com.turkcell.pair8.customerservice.repositories.AddressRepository;
import com.turkcell.pair8.customerservice.services.abstracts.AddressService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository  addressRepository;
}