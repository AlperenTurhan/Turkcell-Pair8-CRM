package com.turkcell.pair8.customerservice.repositories;

import com.turkcell.pair8.customerservice.entities.Contact;
import com.turkcell.pair8.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    Optional<Contact> findByCustomerId(int customerId);
}
