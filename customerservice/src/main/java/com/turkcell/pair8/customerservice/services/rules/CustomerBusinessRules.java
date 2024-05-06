package com.turkcell.pair8.customerservice.services.rules;

import com.turkcell.pair8.core.exception.types.BusinessException;
import com.turkcell.pair8.core.services.MessageService;
import com.turkcell.pair8.customerservice.entities.Account;
import com.turkcell.pair8.customerservice.entities.IndividualCustomer;
import com.turkcell.pair8.customerservice.repositories.AccountRepository;
import com.turkcell.pair8.customerservice.repositories.CustomerRepository;
import com.turkcell.pair8.customerservice.services.messages.CustomerMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerBusinessRules
{
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final MessageService messageService;

    public void customerWithSameNationalityIDCanNotExist(String nationalityID)
    {
        Optional<IndividualCustomer> customer = customerRepository.findByNationalityID(nationalityID);

        if(customer.isPresent())
            throw new BusinessException(messageService.getMessage(CustomerMessages.BusinessErrors.CUSTOMERS_WITH_SAME_NATIONAL_ID_SHOULD_NOT_EXIST));
    }

    public void accountWithSameNameCanNotExist(String name)
    {
        Optional<Account> account = accountRepository.findByName(name);

        if(account.isPresent())
            throw new BusinessException(messageService.getMessage(CustomerMessages.BusinessErrors.ACCOUNTS_WITH_SAME_NAME_SHOULD_NOT_EXIST));
    }
}