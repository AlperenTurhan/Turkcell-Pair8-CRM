package com.turkcell.pair8.customerservice.entities;

import com.turkcell.pair8.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers") //Veritabanında tablo adı
@Inheritance(strategy = InheritanceType.JOINED)//Her alt sınıf için ayrı tablo oluşturur.
@SQLDelete(sql = "UPDATE customers SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Customer extends BaseEntity {
    @Column(name = "customer_id", nullable = false, unique = true)
    private String customerID;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) // fetch = FetchType.LAZY: İlişkili tablodan veri çekilirken ilişkili tablonun verileri çekilmez.
    private List<Address> addresses;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true) //Customer entity'si silindiğinde Contact entity'si de silinir.
    private Contact contact;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;
}