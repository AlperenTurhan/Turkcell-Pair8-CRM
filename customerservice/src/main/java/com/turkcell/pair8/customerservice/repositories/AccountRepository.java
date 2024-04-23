package com.turkcell.pair8.customerservice.repositories;

import com.turkcell.pair8.customerservice.entities.Account;
import com.turkcell.pair8.customerservice.entities.Contact;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Optional<Account> findByCustomerId(int customerId);
    Optional<Account> findByName(String name);
}