package com.turkcell.pair8.productservice.repositories;

import com.turkcell.pair8.productservice.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
    Optional<Seller> findBySellerId(String sellerID);
}
