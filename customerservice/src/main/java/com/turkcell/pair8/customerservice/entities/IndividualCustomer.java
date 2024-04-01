package com.turkcell.pair8.customerservice.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Individual")
public class IndividualCustomer extends Customer{
    public IndividualCustomer() {
    }
}
