package com.turkcell.pair8.customerservice.services.concretes;

import com.turkcell.pair8.customerservice.clients.OrderServiceClient;
import com.turkcell.pair8.customerservice.core.exception.types.BusinessException;
import com.turkcell.pair8.customerservice.core.services.abstracts.MessageService;
import com.turkcell.pair8.customerservice.core.services.constants.Messages;
import com.turkcell.pair8.customerservice.entities.Customer;
import com.turkcell.pair8.customerservice.repositories.CustomerRepository;
import com.turkcell.pair8.customerservice.services.abstracts.CustomerService;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.AddCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.SearchCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.UpdateCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;
import com.turkcell.pair8.customerservice.services.mappers.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final MessageService messageService;
    private final OrderServiceClient orderServiceClient;
    private final WebClient.Builder webClient;

    @Override
    public List<SearchCustomerResponse> search(SearchCustomerRequest request) {
        int result = orderServiceClient.getCustomerIdByOrderId(request.getOrderNumber());
        System.out.println("Order servisten gelen sonuç:"+result);
        return customerRepository.search(request);
    }

    @Override
    public void add(AddCustomerRequest request) {
        customersWithSameNationalityIDShouldNotExist(request.getNationalityID());
        Customer customer = CustomerMapper.INSTANCE.customerFromAddRequest(request);
        customer.setCustomerID(UUID.randomUUID().toString());
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        if (!isIdExist(id)) {
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.NOT_FOUND_ERROR, id));
        }
        customerRepository.deleteById(id);
    }

    @Override
    public void update(UpdateCustomerRequest request) {
        Customer customer = customerRepository.findByNationalityID(request.getNationalityID())
                .orElseThrow(() -> new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.NOT_FOUND_ERROR, request.getNationalityID())));
        CustomerMapper.INSTANCE.updateCustomerFromRequest(request, customer);
        customerRepository.save(customer);
    }

    public void customersWithSameNationalityIDShouldNotExist(int nationalityID) {
        if (customerRepository.existsByNationalityID(nationalityID)) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CUSTOMERS_WITH_SAME_NATIONAL_ID_SHOULD_NOT_EXIST));
        }
    }

    public boolean isIdExist(int id) {
        return customerRepository.existsById(id);
    }
}