package com.turkcell.pair8.customerservice.controllers;

import com.turkcell.pair8.customerservice.services.abstracts.CustomerService;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.AddCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.SearchCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@NoArgsConstructor
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("search")
    public List<SearchCustomerResponse> search(@RequestBody SearchCustomerRequest request)
    {
        return customerService.search(request);
    }

    @PostMapping("add")
    void add(@RequestBody @Valid AddCustomerRequest request)
    {
        customerService.add(request);
    }

}