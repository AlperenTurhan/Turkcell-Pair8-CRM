package com.turkcell.pair8.customerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "addresses")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name="city")
    private String city;

    @Column(name="street")
    private String street;

    @Column(name="house_number")
    private String houseNumber;

    @Column(name="description")
    private String description;

    @ManyToOne()
    @JoinColumn(name="customer_id")
    private Customer customer;
}
