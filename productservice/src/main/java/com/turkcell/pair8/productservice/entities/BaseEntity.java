package com.turkcell.pair8.productservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "createdDate", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updatedDate")
    private LocalDateTime updatedDate;

    @Column(name = "deletedDate")
    private LocalDateTime deletedDate;

    @PrePersist // Before saving the entity, set the createdDate
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate // Before updating the entity, set the updatedDate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
