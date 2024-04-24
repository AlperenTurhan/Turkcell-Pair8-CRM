package com.turkcell.pair8.customerservice.controllers;

import com.turkcell.pair8.customerservice.entities.Contact;
import com.turkcell.pair8.customerservice.services.abstracts.ContactService;
import com.turkcell.pair8.customerservice.services.concretes.ContactServiceImpl;
import com.turkcell.pair8.customerservice.services.dtos.Contact.request.AddContactRequest;
import com.turkcell.pair8.customerservice.services.dtos.Contact.request.UpdateContactRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/contactmedium")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @GetMapping("getContact")
    @ResponseStatus(HttpStatus.OK)
    Optional<Contact> getContact(int customerId){
       return contactService.getContact(customerId);
    }
    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddContactRequest add(@Valid @RequestBody AddContactRequest request){
        return contactService.add(request);
    }

    @PutMapping("updateContact")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateContactRequest request) {
     contactService.update(request);
    }

}
