package com.turkcell.pair8.customerservice.controllers;

import com.turkcell.pair8.customerservice.entities.Customer;
import com.turkcell.pair8.customerservice.services.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public Customer getCustomerById(int id) {
        return customerService.getCustomerById(id);
    }

    public Customer saveCustomer(Customer customer) {
        return customerService.saveCustomer(customer);
    }

    public void deleteCustomer(int id) {
        customerService.deleteCustomer(id);
    }
}
