package com.turkcell.pair8.customerservice.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "corporate_customers")
public class CorporateCustomer extends Customer{
    private String companyName;
    private String taxNumber;
    private String sector;
}
