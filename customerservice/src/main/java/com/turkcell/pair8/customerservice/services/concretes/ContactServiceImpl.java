package com.turkcell.pair8.customerservice.services.concretes;

import com.turkcell.pair8.core.exception.types.BusinessException;
import com.turkcell.pair8.core.services.MessageService;
import com.turkcell.pair8.customerservice.entities.Contact;
import com.turkcell.pair8.customerservice.repositories.ContactRepository;
import com.turkcell.pair8.customerservice.services.abstracts.ContactService;
import com.turkcell.pair8.customerservice.services.dtos.contact.request.AddContactRequest;
import com.turkcell.pair8.customerservice.services.dtos.contact.request.UpdateContactRequest;
import com.turkcell.pair8.customerservice.services.mappers.ContactMapper;
import com.turkcell.pair8.customerservice.services.messages.CustomerMessages;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final MessageService messageService;
    @Override
    public Optional<Contact> getContact(int customerId) {
        return contactRepository.findByCustomerId(customerId);
    }

    @Override
    public void update(UpdateContactRequest request) {

        Contact contact = contactRepository.findByCustomerId(request.getCustomerId())
                .orElseThrow(() -> new BusinessException(messageService.getMessage(CustomerMessages.BusinessErrors.NOT_FOUND_ERROR)));

        ContactMapper.INSTANCE.updateContactFromRequest(request, contact);
        contactRepository.save(contact);
    }
    public AddContactRequest add(AddContactRequest request){
        Contact contact = ContactMapper.INSTANCE.addContactFromRequest(request);
        contactRepository.save(contact);
        return request;
    }
}
