package com.example.minego.Users;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getId() {
        User user = new User();
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    void setId() {
        User user = new User();
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    void getNames() {
        User user = new User();
        user.setNames("Juan");
        assertEquals("Juan", user.getNames());
    }

    @Test
    void setNames() {
        User user = new User();
        user.setNames("Juan");
        assertEquals("Juan", user.getNames());
    }

    @Test
    void getEmail() {
        User user = new User();
        user.setEmail("arif@ymail.com");
        assertEquals("arif@ymail.com", user.getEmail());
    }

    @Test
    void setEmail() {
        User user = new User();
        user.setEmail("arif@ymail.com");
        assertEquals("arif@ymail.com", user.getEmail());
    }

    @Test
    void getCellPhone() {
        User user = new User();
        user.setCellPhone("123456789");
        assertEquals("123456789", user.getCellPhone());
    }

    @Test
    void setCellPhone() {
        User user = new User();
        user.setCellPhone("123456789");
        assertEquals("123456789", user.getCellPhone());
    }

    @Test
    void getIdentificationType() {
        User user = new User();
        user.setIdentificationType(IdentificationType.DNI);
        assertEquals(IdentificationType.DNI, user.getIdentificationType());
    }

    @Test
    void setIdentificationType() {
        User user = new User();
        user.setIdentificationType(IdentificationType.DNI);
        assertEquals(IdentificationType.DNI, user.getIdentificationType());
    }

    @Test
    void getIdentificationNumber() {
        User user = new User();
        user.setIdentificationNumber("12345678");
        assertEquals("12345678", user.getIdentificationNumber());
    }

    @Test
    void setIdentificationNumber() {
        User user = new User();
        user.setIdentificationNumber("12345678");
        assertEquals("12345678", user.getIdentificationNumber());
    }

    @Test
    void getMainProvince() {
        User user = new User();
        user.setMainProvince("Lima");
        assertEquals("Lima", user.getMainProvince());
    }

    @Test
    void setMainProvince() {
        User user = new User();
        user.setMainProvince("Lima");
        assertEquals("Lima", user.getMainProvince());
    }

    @Test
    void getMainCity() {
        User user = new User();
        user.setMainCity("Lima");
        assertEquals("Lima", user.getMainCity());
    }

    @Test
    void setMainCity() {
        User user = new User();
        user.setMainCity("Lima");
        assertEquals("Lima", user.getMainCity());
    }

    @Test
    void getMainAddress() {
        User user = new User();
        user.setMainAddress("Av. Lima 123");
        assertEquals("Av. Lima 123", user.getMainAddress());
    }

    @Test
    void setMainAddress() {
        User user = new User();
        user.setMainAddress("Av. Lima 123");
        assertEquals("Av. Lima 123", user.getMainAddress());
    }
}