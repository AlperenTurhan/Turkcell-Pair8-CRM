package com.turkcell.pair8.customerservice.services.concretes;

import com.turkcell.pair8.customerservice.repositories.AccountRepository;
import com.turkcell.pair8.customerservice.services.abstracts.AccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
}