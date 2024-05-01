package com.turkcell.pair8.invoiceservice.repositories;

import com.turkcell.pair8.invoiceservice.entities.Address;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
