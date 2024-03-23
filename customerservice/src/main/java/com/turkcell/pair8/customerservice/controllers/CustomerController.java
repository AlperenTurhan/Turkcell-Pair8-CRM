package com.turkcell.pair8.customerservice.controllers;

import com.turkcell.pair8.customerservice.services.abstracts.CustomerService;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.AddCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.SearchCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping("search")
    public List<SearchCustomerResponse> search(@RequestBody SearchCustomerRequest request)
    {
        return customerService.search(request);
    }

    @PostMapping("add")
    void add(@RequestBody AddCustomerRequest request)
    {
        customerService.add(request);
    }

}