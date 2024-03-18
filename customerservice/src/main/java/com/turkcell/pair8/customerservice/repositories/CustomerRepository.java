package com.turkcell.pair8.customerservice.repositories;

import com.turkcell.pair8.customerservice.entities.Customer;
import com.turkcell.pair8.customerservice.services.dtos.customer.request.SearchCustomerRequest;
import com.turkcell.pair8.customerservice.services.dtos.customer.response.SearchCustomerResponse;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("Select new com.turkcell.pair8.customerservice.services.dtos.customer.response." +
            "SearchCustomerResponse(c.customerId, c.firstName, c.lastName, c.middleName, c.nationalityId)" +
            " from Customer c" +
            " where ( :nationalityId <= 0 or c.nationalityId= nationalityId)" +
            " and ( :customerId is null or c.customerId= :customerId)")
    List<SearchCustomerResponse> search(SearchCustomerRequest request);
}