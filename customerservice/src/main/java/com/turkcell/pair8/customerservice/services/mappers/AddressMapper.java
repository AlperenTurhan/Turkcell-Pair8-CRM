package com.turkcell.pair8.customerservice.services.mappers;

import com.turkcell.pair8.customerservice.entities.Address;
import com.turkcell.pair8.customerservice.services.dtos.address.request.UpdateAddressRequest;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    @Mapping(target = "id", ignore = true) // Güncelleme sırasında id değeri değişmemeli
    void updateAddressFromRequest(UpdateAddressRequest request, @MappingTarget Address address);

    Address addressFromUpdateRequest(UpdateAddressRequest request);
}
