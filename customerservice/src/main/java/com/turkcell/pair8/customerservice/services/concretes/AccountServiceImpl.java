package com.turkcell.pair8.customerservice.services.concretes;

import com.pair4.paging.PageInfo;
import com.turkcell.pair8.core.exception.types.BusinessException;
import com.turkcell.pair8.customerservice.entities.Account;
import com.turkcell.pair8.customerservice.entities.AccountStatus;
import com.turkcell.pair8.customerservice.entities.AccountType;
import com.turkcell.pair8.customerservice.repositories.AccountRepository;
import com.turkcell.pair8.customerservice.services.abstracts.AccountService;
import com.turkcell.pair8.customerservice.services.dtos.account.request.AddAccountRequest;
import com.turkcell.pair8.customerservice.services.dtos.account.request.UpdateAccountRequest;
import com.turkcell.pair8.customerservice.services.dtos.account.response.AddAccountResponse;
import com.turkcell.pair8.customerservice.services.dtos.account.response.GetAllAccountResponse;
import com.turkcell.pair8.customerservice.services.mappers.AccountMapper;
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
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final CustomerBusinessRules customerBusinessRules;

    @Override
    public List<GetAllAccountResponse> getAll(PageInfo pageInfo) {
        PageRequest pageRequest = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        List<Account> accounts = accountRepository.findAll(pageRequest).getContent();
        return accounts.stream().map(AccountMapper.INSTANCE::dtoFromGetAllRequest).collect(Collectors.toList());
    }

    @Override
    public AddAccountResponse add(AddAccountRequest request) {
        customerBusinessRules.accountWithSameNameCanNotExist(request.getName());

        Account account = AccountMapper.INSTANCE.accountFromAddRequest(request);
        account.setType(AccountType.BILLING);
        account.setNumber(UUID.randomUUID().toString());
        account.setStatus(AccountStatus.ACTIVE);

        return AccountMapper.INSTANCE.responseFromAddRequest(account);
    }

    @Override
    public void delete(int id) { // TODO: Hesaba bağlı ürün kontrolü yapılacak
        if (!isIdExist(id)) {
            throw new BusinessException(CustomerMessages.BusinessErrors.NOT_FOUND_ERROR);
        }
        accountRepository.deleteById(id);
    }

    @Override
    public void update(UpdateAccountRequest request) {
    }

    public boolean isIdExist(int id) {
        return accountRepository.existsById(id);
    }
}