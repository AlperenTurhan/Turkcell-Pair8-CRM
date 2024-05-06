package com.turkcell.pair8.customerservice.services.concretes;

import com.pair4.paging.PageInfo;
import com.turkcell.pair8.core.exception.types.BusinessException;
import com.turkcell.pair8.core.services.MessageService;
import com.turkcell.pair8.customerservice.entities.IndividualCustomer;
import com.turkcell.pair8.customerservice.repositories.CustomerRepository;
import com.turkcell.pair8.customerservice.services.abstracts.CustomerService;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.AddCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.SearchCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.UpdateCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.AddCustomerResponse;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.GetAllCustomerResponse;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;
import com.turkcell.pair8.customerservice.services.mappers.CustomerMapper;
import com.turkcell.pair8.customerservice.services.messages.CustomerMessages;
import com.turkcell.pair8.customerservice.services.rules.CustomerBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerBusinessRules customerBusinessRules;
    private final MessageService messageService;

    @Override
    public List<SearchCustomerResponse> search(SearchCustomerRequest request) {
        return customerRepository.search(request);
    }

    @Override
    public List<GetAllCustomerResponse> getAll(PageInfo pageInfo) {
        PageRequest pageRequest = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        List<IndividualCustomer> customers = customerRepository.findAll(pageRequest).getContent();
        return customers.stream().map(CustomerMapper.INSTANCE::dtoFromGetAllRequest).collect(Collectors.toList());
    }

    @Override
    public AddCustomerResponse add(AddCustomerRequest request) {
        customerBusinessRules.customerWithSameNationalityIDCanNotExist(request.getNationalityID());

        IndividualCustomer customer = CustomerMapper.INSTANCE.customerFromAddRequest(request);
        customer.setCustomerID(UUID.randomUUID().toString());
        customerRepository.save(customer);

        return CustomerMapper.INSTANCE.responseFromAddRequest(customer);
    }

    @Override
    public void delete(int id) {
        if (!isIdExist(id)) {
            throw new BusinessException(messageService.getMessageWithArgs(CustomerMessages.BusinessErrors.NOT_FOUND_ERROR, id));
        }
        customerRepository.deleteById(id);
    }

    @Override
    public void update(UpdateCustomerRequest request) {
        IndividualCustomer customer = customerRepository.findByNationalityID(request.getNationalityID())
                .orElseThrow(() -> new BusinessException(messageService.getMessage(CustomerMessages.BusinessErrors.NOT_FOUND_ERROR)));

        CustomerMapper.INSTANCE.updateCustomerFromRequest(request, customer);
        customerRepository.save(customer);
    }

    public boolean isIdExist(int id) {
        return customerRepository.existsById(id);
    }
}