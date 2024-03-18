package com.turkcell.pair8.customerservice.controllers;

import com.turkcell.pair8.customerservice.services.abstracts.CustomerService;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.SearchCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("search")
    public List<SearchCustomerResponse> search(@RequestBody SearchCustomerRequest request)
    {
        return customerService.search(request);
    }
}