package com.turkcell.pair8.customerservice.repositories;

import com.turkcell.pair8.customerservice.entities.Customer;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.SearchCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT new com.turkcell.pair8.customerservice.services.dtos.customer.response." +
            "SearchCustomerResponse(c.customerID, c.firstName, c.middleName, c.lastName, c.nationalityID)" +
            " FROM Customer c" +
            " WHERE (:#{#request.getNationalityID()} <= 0 OR c.nationalityID = :#{#request.getNationalityID()})" +
            " AND (:#{#request.getCustomerID()} IS NULL OR c.customerID = :#{#request.getCustomerID()})" +
            " AND (:#{#request.getAccountNumber()} IS NULL OR EXISTS (SELECT 1 FROM c.accounts a WHERE a.number = :#{#request.getAccountNumber()}))" +
            " AND (:#{#request.getGsmNumber()} IS NULL OR EXISTS (SELECT 1 FROM c.contact con WHERE con.mobilePhone = :#{#request.getGsmNumber()}))" +
            " AND (:#{#request.getFirstName()} IS NULL OR c.firstName = :#{#request.getFirstName()})" +
            " AND (:#{#request.getLastName()} IS NULL OR c.lastName = :#{#request.getLastName()}))")
    List<SearchCustomerResponse> search(@Param("request") SearchCustomerRequest request);

    boolean existsByNationalityID(int nationalityID);
}