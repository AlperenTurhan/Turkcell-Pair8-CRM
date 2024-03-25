package com.turkcell.pair8.customerservice.controllers;

import com.turkcell.pair8.customerservice.services.abstracts.AddressService;
import com.turkcell.pair8.customerservice.services.dtos.address.request.AddAddressRequest;
import com.turkcell.pair8.customerservice.services.dtos.address.request.UpdateAddressRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.AddCustomerRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @PostMapping("add")
    void add(@RequestBody AddAddressRequest request)
    {
        addressService.add(request);
    }
    @PutMapping("update")
    void update(@RequestBody UpdateAddressRequest request) { addressService.update(request);}
    @PostMapping("delete")
    void delete(@RequestParam int id) {addressService.delete(id);}
}