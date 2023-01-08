package com.example.minego.Addresses;

import com.example.minego.Users.User;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceGenerator")
    @SequenceGenerator(name = "SequenceGenerator", sequenceName = "address_id_seq", allocationSize = 1)
    private Long id;

    private String address;

    private String province;

    private String city;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
