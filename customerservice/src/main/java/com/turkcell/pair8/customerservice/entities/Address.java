package com.turkcell.pair8.customerservice.entities;

import com.turkcell.pair8.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
public class Address extends BaseEntity {
    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "house_flat_number", nullable = false)
    private String houseFlatNumber;

    @Column(name = "address_description", nullable = false)
    private String addressDescription;

    @ManyToOne(fetch = FetchType.LAZY) // Address entity'si yüklendiğinde Customer entity'si yüklenmez.
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true) //Address entity'si silindiğinde Contact entity'si de silinir.
    private Account account;
}