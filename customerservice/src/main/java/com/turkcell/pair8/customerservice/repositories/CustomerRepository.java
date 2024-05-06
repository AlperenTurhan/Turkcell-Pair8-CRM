package com.turkcell.pair8.customerservice.repositories;

import com.turkcell.pair8.customerservice.entities.Customer;
import com.turkcell.pair8.customerservice.entities.IndividualCustomer;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.SearchCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<IndividualCustomer, Integer> {

    @Query("Select new com.turkcell.pair8.customerservice.services.dtos.customer.response." +
            "SearchCustomerResponse(c.customerID, c.firstName, c.middleName, c.lastName, c.nationalityID)" +
            " from Customer c" +
            " where ( :#{#request.getNationalityID()} is null or c.nationalityID= :#{#request.getNationalityID()})" +
            " and ( :#{#request.getCustomerID()} is null or c.customerID= :#{#request.getCustomerID()})" +
            " and ( :#{#request.getFirstName()} is null or c.firstName= :#{#request.getFirstName()})" +
            " and ( :#{#request.getLastName()} is null or c.lastName= :#{#request.getLastName()})")
    List<SearchCustomerResponse> search(@Param("request") SearchCustomerRequest request);

    boolean existsByNationalityID(String nationalityID);

    Optional<IndividualCustomer> findByNationalityID(String nationalityID); //optinal kullanmamızın sebebi null dönme ihtimali olmasıdır.
}