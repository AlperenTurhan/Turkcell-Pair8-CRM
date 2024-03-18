package com.turkcell.pair8.customerservice.services.concretes;

import com.turkcell.pair8.customerservice.repositories.CustomerRepository;
import com.turkcell.pair8.customerservice.services.abstracts.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
}