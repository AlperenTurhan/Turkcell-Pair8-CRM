package com.turkcell.pair8.customerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "father_name")
    private String fatherName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "nationality_id", nullable = false, unique = true)
    private String nationalityID;

    @Column(nullable = false)
    private String email;

    @Column(name = "home_phone_number")
    private String homePhoneNumber;

    @Column(name = "mobile_phone_number")
    private String mobilePhoneNumber;

    @Column(name = "fax_number")
    private String faxNumber;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Account> accounts;
}
