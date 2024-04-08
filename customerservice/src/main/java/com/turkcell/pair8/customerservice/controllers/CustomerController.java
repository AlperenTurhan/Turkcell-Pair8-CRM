package com.turkcell.pair8.customerservice.controllers;

import com.turkcell.pair8.customerservice.core.paging.PageInfo;
import com.turkcell.pair8.customerservice.services.abstracts.CustomerService;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.AddCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.SearchCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.UpdateCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.AddCustomerResponse;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.GetAllCustomerResponse;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("search")
    @ResponseStatus(HttpStatus.OK)
    public List<SearchCustomerResponse> search(@RequestBody SearchCustomerRequest request)
    {
        return customerService.search(request);
    }

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddCustomerResponse add(@RequestBody @Valid AddCustomerRequest request)
    {
        return customerService.add(request);
    }

    @GetMapping("getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCustomerResponse> getAll(@RequestParam int page, @RequestParam int size)
    {
        PageInfo pageInfo = new PageInfo(page,size);
        return customerService.getAll(pageInfo);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateCustomerRequest request)
    {
        customerService.update(request);
    }
}