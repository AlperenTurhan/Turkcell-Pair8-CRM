package com.turkcell.pair8.customerservice.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Corporate")
public class CorporateCustomer extends Customer{
    public CorporateCustomer() {
    }
}
