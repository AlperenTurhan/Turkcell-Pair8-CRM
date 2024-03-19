package com.turkcell.pair8.customerservice.repositories;

import com.turkcell.pair8.customerservice.entities.Customer;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT new com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse" +
            "(c.customerID, c.firstName, c.middleName, c.lastName, c.nationalityID)" +
            " FROM Customer c LEFT JOIN c.accounts a" +
            " WHERE (:nationalityID IS NULL OR c.nationalityID = :nationalityID)" +
            " AND (:customerID IS NULL OR c.customerID = :customerID)" +
            " AND (:accountNumber IS NULL OR a.number = :accountNumber)" +
            " AND (:gsmNumber IS NULL OR c.gsmNumber = :gsmNumber)" +
            " AND (:firstName IS NULL OR c.firstName LIKE %:firstName%)" +
            " AND (:lastName IS NULL OR c.lastName LIKE %:lastName%)")
    List<SearchCustomerResponse> search(@Param("nationalityID") Integer nationalityID,
                                        @Param("customerID") String customerID,
                                        @Param("accountNumber") String accountNumber,
                                        @Param("gsmNumber") String gsmNumber,
                                        @Param("firstName") String firstName,
                                        @Param("lastName") String lastName);

}