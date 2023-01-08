package com.example.minego.Addresses;

import com.example.minego.Users.User;
import jakarta.persistence.*;

import java.util.List;

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

    public Address(String address, String province, String city) {
        this.address = address;
        this.province = province;
        this.city = city;
    }

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
