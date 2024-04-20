package com.turkcell.pair8.customerservice.services.concretes;

import com.turkcell.pair8.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair8.customerservice.core.services.abstracts.MessageService;
import com.turkcell.pair8.customerservice.core.services.constants.Messages;
import com.turkcell.pair8.customerservice.entities.Contact;
import com.turkcell.pair8.customerservice.repositories.ContactRepository;
import com.turkcell.pair8.customerservice.services.abstracts.ContactService;
import com.turkcell.pair8.customerservice.services.dtos.Contact.request.AddContactRequest;
import com.turkcell.pair8.customerservice.services.dtos.Contact.request.UpdateContactRequest;
import com.turkcell.pair8.customerservice.services.mappers.ContactMapper;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final MessageService messageService;
    private final ContactRepository contactRepository;
    @Override
    public Optional<Contact> getContact(int customerId) {
        return contactRepository.findByCustomerId(customerId);
    }

    @Override
    public void update(UpdateContactRequest request) {

        Contact contact = contactRepository.findByCustomerId(request.getCustomerId())
                .orElseThrow(() -> new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.NOT_FOUND_ERROR, request.getCustomerId())));

        ContactMapper.INSTANCE.updateContactFromRequest(request, contact);
        contactRepository.save(contact);
    }
    public AddContactRequest add(AddContactRequest request){
        Contact contact = ContactMapper.INSTANCE.addContactFromRequest(request);
        contactRepository.save(contact);
        return request;
    }
}
