package com.turkcell.pair8.customerservice.services.concretes;

import com.turkcell.pair8.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair8.customerservice.repositories.CustomerRepository;
import com.turkcell.pair8.customerservice.services.abstracts.CustomerService;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.SearchCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    @Override
    public List<SearchCustomerResponse> search(SearchCustomerRequest request) {
        List<SearchCustomerResponse> searchResults = customerRepository.search(request);
        if (searchResults.isEmpty()) {
            throw new BusinessException("No customer found! Would you like to create the customer?");
        }
        return customerRepository.search(request);
    }
}