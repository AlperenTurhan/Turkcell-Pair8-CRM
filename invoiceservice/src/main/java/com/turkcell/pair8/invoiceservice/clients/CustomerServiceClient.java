package com.turkcell.pair8.invoiceservice.clients;

import com.turkcell.pair8.invoiceservice.services.dtos.requests.AddAddressRequest;
import com.turkcell.pair8.invoiceservice.services.dtos.requests.UpdateAddressRequest;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "customerservice")
public interface CustomerServiceClient {

    @PostMapping("/api/addresses")
    int add(@RequestBody @Valid AddAddressRequest request);

    @PutMapping("/api/addresses")
    void update(@RequestBody @Valid UpdateAddressRequest updateAddressRequest);
}
