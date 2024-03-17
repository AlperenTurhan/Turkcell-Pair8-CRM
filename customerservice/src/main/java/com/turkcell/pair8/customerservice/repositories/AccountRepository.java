package com.turkcell.pair8.customerservice.repositories;

import com.turkcell.pair8.customerservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
