package com.turkcell.pair8.customerservice.services.abstracts;

import com.turkcell.pair8.customerservice.entities.Contact;
import com.turkcell.pair8.customerservice.services.dtos.Contact.request.AddContactRequest;
import com.turkcell.pair8.customerservice.services.dtos.Contact.request.UpdateContactRequest;

import java.util.Optional;

public interface ContactService {
    Optional<Contact> getContact(int customerId);
    void update(UpdateContactRequest request);
    AddContactRequest add(AddContactRequest request);
}
