package com.example.minego.Users;


import com.example.minego.Addresses.Address;
import jakarta.persistence.*;

import java.util.List;



@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceGenerator")
    @SequenceGenerator(name = "SequenceGenerator", sequenceName = "users_id_seq", allocationSize = 1)

    private Long id;

    private IdentificationType identificationType;

    private String identificationNumber;
    private String names;

    private String email;

    private String cellPhone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;



    public User() {
    }

    public User(Long id, String names, String email, String cellPhone) {
        this.id = id;
        this.names = names;
        this.email = email;
        this.cellPhone = cellPhone;
    }

    public User(String names, String email, String cellPhone) {
        this.names = names;
        this.email = email;
        this.cellPhone = cellPhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}
