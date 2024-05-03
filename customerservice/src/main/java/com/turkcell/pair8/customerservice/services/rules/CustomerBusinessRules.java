package com.turkcell.pair8.customerservice.services.rules;


import com.turkcell.pair8.core.exception.types.BusinessException;
import com.turkcell.pair8.core.services.abstracts.MessageService;
import com.turkcell.pair8.core.services.constants.Messages;
import com.turkcell.pair8.customerservice.entities.Account;
import com.turkcell.pair8.customerservice.entities.Customer;
import com.turkcell.pair8.customerservice.repositories.AccountRepository;
import com.turkcell.pair8.customerservice.repositories.CustomerRepository;
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
        Optional<Customer> customer = customerRepository.findByNationalityID(nationalityID);

        if(customer.isPresent())
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.CUSTOMERS_WITH_SAME_NATIONAL_ID_SHOULD_NOT_EXIST));
    }

    public void accountWithSameNameCanNotExist(String name)
    {
        Optional<Account> account = accountRepository.findByName(name);

        if(account.isPresent())
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.ACCOUNTS_WITH_SAME_NAME_SHOULD_NOT_EXIST));
    }
}