package com.turkcell.pair8.customerservice.repositories;

import com.turkcell.pair8.customerservice.entities.Customer;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.SearchCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("Select new com.turkcell.pair8.customerservice.services.dtos.customer.response." +
            "SearchCustomerResponse(c.customerID, c.firstName, c.middleName, c.lastName, c.nationalityID)" +
            " from Customer c" +
            " where ( :#{#request.getNationalityID()} <= 0 or c.nationalityID= :#{#request.getNationalityID()})" +
            " and ( :#{#request.getCustomerID()} is null or c.customerID= :#{#request.getCustomerID()})")
    List<SearchCustomerResponse> search(@Param("request") SearchCustomerRequest request);

    boolean existsByNationalityID(int nationalityID);

    Optional<Customer> findByNationalityID(int nationalityID);
}