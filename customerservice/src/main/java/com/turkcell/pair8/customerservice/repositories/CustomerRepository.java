package com.turkcell.pair8.customerservice.repositories;

import com.turkcell.pair8.customerservice.entities.Customer;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.SearchCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("Select new com.turkcell.customerservice.services.dtos.responses." +
            "SearchCustomerResponse(c.customerId, c.firstName, c.lastName, c.secondName, c.nationalityId)" +
            " from Customer c" +
            " where ( :#{#request.getNationalityId()} <= 0 or c.nationalityId= :#{#request.getNationalityId()})" +
            " and ( :#{#request.getCustomerId()} is null or c.customerId= :#{#request.getCustomerId()})")
        // Parameter SPEL Expression (Spring Expression)
    List<SearchCustomerResponse> search(SearchCustomerRequest request);

    boolean existsByNationalityID(int nationalityID);
}