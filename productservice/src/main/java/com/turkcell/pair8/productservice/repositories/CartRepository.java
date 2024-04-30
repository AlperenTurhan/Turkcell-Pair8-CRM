package com.turkcell.pair8.productservice.repositories;

import com.turkcell.pair8.customerservice.entities.Contact;
import com.turkcell.pair8.customerservice.entities.Customer;
import com.turkcell.pair8.productservice.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByCustomerId(int customerId);
}
