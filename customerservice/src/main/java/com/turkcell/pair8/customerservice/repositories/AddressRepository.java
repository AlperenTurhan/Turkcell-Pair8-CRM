package com.turkcell.pair8.customerservice.repositories;

import com.turkcell.pair8.customerservice.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}