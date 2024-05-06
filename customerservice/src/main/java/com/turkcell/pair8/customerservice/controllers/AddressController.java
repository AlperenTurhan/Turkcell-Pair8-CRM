package com.turkcell.pair8.customerservice.controllers;

import com.turkcell.pair8.customerservice.services.abstracts.AddressService;
import com.turkcell.pair8.customerservice.services.dtos.address.request.AddAddressRequest;
import com.turkcell.pair8.customerservice.services.dtos.address.request.UpdateAddressRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping("add")
    public AddAddressRequest add(@RequestBody @Valid AddAddressRequest request)
    {
        return addressService.add(request);
    }
    @PutMapping("update")
    void update(@RequestBody UpdateAddressRequest request) { addressService.update(request);}
    @PostMapping("delete")
    void delete(@RequestParam int id) {addressService.delete(id);}
}