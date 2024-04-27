package com.turkcell.pair8.productservice.entities;

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
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(name = "product_id", nullable = false, unique = true)
    private String productID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "unit_price")
    private float unitPrice;

    @Column(name = "stock")
    private int stock;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    private Seller seller;

    @ManyToMany(mappedBy = "products")
    private Set<Category> categories;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartProducts> cartProducts;
}
