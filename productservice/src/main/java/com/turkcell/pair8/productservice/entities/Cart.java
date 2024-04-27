package com.turkcell.pair8.productservice.entities;

import com.turkcell.pair8.customerservice.entities.Customer;
import com.turkcell.pair8.productservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carts")
public class Cart extends BaseEntity {

    // TODO: feignclient ile customerservice import etmeden customera ulaşma
    // TODO: list yerine set kullan
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false, unique = true)
    private Customer customer;

    @Column(name = "total_amount")
    private float totalAmount;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartProducts> cartProducts;
}
