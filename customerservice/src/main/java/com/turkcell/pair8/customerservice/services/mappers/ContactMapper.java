package com.turkcell.pair8.customerservice.services.mappers;

import com.turkcell.pair8.customerservice.entities.Contact;
import com.turkcell.pair8.customerservice.services.dtos.Contact.request.AddContactRequest;
import com.turkcell.pair8.customerservice.services.dtos.Contact.request.UpdateContactRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);
    @Mapping(target = "id", ignore = true)
    void updateContactFromRequest(UpdateContactRequest request, @MappingTarget Contact contact);

    @Mapping(source="customerId", target="customer.id")
    Contact addContactFromRequest(AddContactRequest request);
}
