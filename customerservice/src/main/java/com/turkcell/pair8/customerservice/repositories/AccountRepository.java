package com.turkcell.pair8.customerservice.repositories;

import com.turkcell.pair8.customerservice.entities.Account;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
}