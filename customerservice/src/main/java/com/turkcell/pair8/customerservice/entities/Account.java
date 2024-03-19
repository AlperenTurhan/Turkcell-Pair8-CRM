package com.turkcell.pair8.customerservice.entities;

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
public class Account {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;
}
