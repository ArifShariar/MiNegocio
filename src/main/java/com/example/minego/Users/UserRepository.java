package com.example.minego.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // find by identification number
    User findByIdentificationNumber(String identificationNumber);


    // find user by email
    User findByEmail(String email);

    User findByEmailOrIdentificationNumber(String email, String identificationNumber);

    List<User> searchUserByNamesContaining(String name);


    @Query(value = "SELECT main_address , main_province, main_city FROM users WHERE id = ?1", nativeQuery = true)
    List<Object[]> findAddress(Long id);
}
