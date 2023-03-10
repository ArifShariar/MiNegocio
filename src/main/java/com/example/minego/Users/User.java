package com.example.minego.Users;


import com.example.minego.Addresses.Address;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


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

    private String mainProvince;

    private String mainCity;

    private String mainAddress;

    @ManyToOne()
    @JoinColumn(name = "head_office_address_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Address head_office_address;

    public User() {
    }

    public User(Long id, IdentificationType identificationType, String identificationNumber, String names, String email, String cellPhone, String mainProvince, String mainCity, String mainAddress) {
        this.id = id;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.names = names;
        this.email = email;
        this.cellPhone = cellPhone;
        this.mainProvince = mainProvince;
        this.mainCity = mainCity;
        this.mainAddress = mainAddress;
    }

    public User(IdentificationType identificationType, String identificationNumber, String names, String email, String cellPhone, String mainProvince, String mainCity, String mainAddress) {
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.names = names;
        this.email = email;
        this.cellPhone = cellPhone;
        this.mainProvince = mainProvince;
        this.mainCity = mainCity;
        this.mainAddress = mainAddress;
    }

    public User(IdentificationType identificationType, String identificationNumber, String names, String email, String cellPhone, String mainProvince, String mainCity, String mainAddress, Address head_office_address) {
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.names = names;
        this.email = email;
        this.cellPhone = cellPhone;
        this.mainProvince = mainProvince;
        this.mainCity = mainCity;
        this.mainAddress = mainAddress;
        this.head_office_address = head_office_address;
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

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getMainProvince() {
        return mainProvince;
    }

    public void setMainProvince(String mainProvince) {
        this.mainProvince = mainProvince;
    }

    public String getMainCity() {
        return mainCity;
    }

    public void setMainCity(String mainCity) {
        this.mainCity = mainCity;
    }

    public String getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(String mainAddress) {
        this.mainAddress = mainAddress;
    }

    public Address getHead_office_address() {
        return head_office_address;
    }

    public void setHead_office_address(Address head_office_address) {
        this.head_office_address = head_office_address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", identificationType=" + identificationType +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", names='" + names + '\'' +
                ", email='" + email + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", mainProvince='" + mainProvince + '\'' +
                ", mainCity='" + mainCity + '\'' +
                ", mainAddress='" + mainAddress + '\'' +
                '}';
    }
}
