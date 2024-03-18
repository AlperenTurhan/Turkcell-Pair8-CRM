package com.turkcell.pair8.customerservice.controllers;

import com.turkcell.pair8.customerservice.services.abstracts.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
@AllArgsConstructor
public class AddressController {
    private AddressService addressService;
}