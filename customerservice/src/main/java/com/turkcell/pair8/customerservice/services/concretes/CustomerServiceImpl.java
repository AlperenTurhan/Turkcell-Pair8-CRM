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

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private MessageService messageService;
    private final WebClient.Builder webClient;
    private final OrderServiceClient orderServiceClient;


    @Override
    public List<SearchCustomerResponse> search(SearchCustomerRequest request) {
        // Özellikleri bireysel parametreler olarak çıkar
//        int nationalityId = request.getNationalityID();
//        String customerId = request.getCustomerID();
//        String accountNumber = request.getAccountNumber();
//        String gsmNumber = request.getGsmNumber();
//        String firstName = request.getFirstName();
//        String lastName = request.getLastName();
//
//        // Repository metodunu güncellenmiş parametrelerle çağır
//        List<SearchCustomerResponse> searchResults = customerRepository.search(nationalityId, customerId,
//                                                                                accountNumber, gsmNumber,
//                                                                                firstName, lastName);
//
//        // Sonuçları kontrol et ve dön
//        if (searchResults.isEmpty()) {
//            throw new BusinessException("No customer found! Would you like to create the customer?");
//        }
//        return searchResults;

        int result = orderServiceClient.getCustomerIdByOrderId(request.getOrderNumber());
        System.out.println("Order servisten gelen sonuç:"+result);
        return customerRepository.search(request);
    }

    @Override
    public void add(AddCustomerRequest request) {
        customersWithSameNationalityIDShouldNotExist(request.getNationalityID());
        Customer customer = CustomerMapper.INSTANCE.customerFromAddRequest(request);
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
        CustomerMapper.INSTANCE.updateCustomerFromRequest(request, customer); // Mapper kullanarak güncelleme yap
        customerRepository.save(customer);
    }

    public void customersWithSameNationalityIDShouldNotExist(int nationalityID) {
        if (customerRepository.existsByNationalityID(nationalityID)) {
            throw new BusinessException("Customer with the same nationality ID already exists!");
        }
    }

    public boolean isIdExist(int id) {
        return customerRepository.existsById(id);
    }
}