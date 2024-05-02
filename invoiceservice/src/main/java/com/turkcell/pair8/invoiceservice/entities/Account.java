package com.turkcell.pair8.invoiceservice.entities;


import com.turkcell.pair8.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "accounts")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account extends BaseEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    private String status;

    @Column(name = "number")
    private String number;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "action")
    private String action;

    @Column(name = "description")
    private String description;

    @Column(name = "addressId")
    private int addressId;

    @Column(name = "customerId")
    private int customerId;
}
