package com.turkcell.pair8.customerservice.entities;

import com.turkcell.pair8.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="number", nullable = false)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private AccountStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name="type", nullable = false)
    private AccountType type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="address_id", referencedColumnName = "id", nullable=false)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    //TODO: Product listesi eklenecek
}
