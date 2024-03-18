package com.turkcell.pair8.customerservice.repositories;

import com.turkcell.pair8.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
