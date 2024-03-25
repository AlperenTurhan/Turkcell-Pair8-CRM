package com.turkcell.pair8.customerservice.services.concretes;

import com.turkcell.pair8.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair8.customerservice.core.services.abstracts.MessageService;
import com.turkcell.pair8.customerservice.core.services.constants.Messages;
import com.turkcell.pair8.customerservice.entities.Address;
import com.turkcell.pair8.customerservice.repositories.AddressRepository;
import com.turkcell.pair8.customerservice.services.abstracts.AddressService;
import com.turkcell.pair8.customerservice.services.dtos.address.request.AddAddressRequest;
import com.turkcell.pair8.customerservice.services.dtos.address.request.UpdateAddressRequest;
import com.turkcell.pair8.customerservice.services.mappers.AddressMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository  addressRepository;
    private MessageService messageService;
    @Override
    public void add(AddAddressRequest request) {
        Address address = AddressMapper.INSTANCE.addressFromAddRequest(request);
        addressRepository.save(address);
    }

    @Override
    public void delete(int id) {
        if (!isIdExist(id)) {
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.NOT_FOUND_ERROR, id));
        }
        addressRepository.deleteById(id);
    }

    @Override
    public void update(UpdateAddressRequest request) {
        Address address = AddressMapper.INSTANCE.addressFromUpdateRequest(request);
        addressRepository.save(address);
    }
    public boolean isIdExist(int id) {
        return addressRepository.existsById(id);
    }

}