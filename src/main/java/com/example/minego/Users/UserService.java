package com.example.minego.Users;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        // check if user with same email or identification number exists
        User existingUser = userRepository.findByEmailOrIdentificationNumber(user.getEmail(), user.getIdentificationNumber());
        if (existingUser != null) {
            return null;
        }
        else {
            return userRepository.save(user);
        }
    }

    public List<User> getAllUsersWithAddress() {
        // get all users with their addresses
        return userRepository.findAll();
    }

    public String deleteUser(String identificationNumber) {
        // check if user exists
        User user = userRepository.findByIdentificationNumber(identificationNumber);
        if(user != null) {
            // delete user
            userRepository.delete(user);
            return "User deleted";
        }

        return "User not found";
    }

    public User getUserByIdentificationNumber(String identificationNumber) {
        return userRepository.findByIdentificationNumber(identificationNumber);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            if(user.getIdentificationType()!=null){
                existingUser.setIdentificationType(user.getIdentificationType());
            }
            if(user.getIdentificationNumber()!=null){
                existingUser.setIdentificationNumber(user.getIdentificationNumber());
            }
            if(user.getNames()!=null){
                existingUser.setNames(user.getNames());
            }
            if(user.getEmail()!=null){
                existingUser.setEmail(user.getEmail());
            }
            if(user.getCellPhone()!=null){
                existingUser.setCellPhone(user.getCellPhone());
            }
            if(user.getMainProvince()!=null){
                existingUser.setMainProvince(user.getMainProvince());
            }
            if(user.getMainCity()!=null){
                existingUser.setMainCity(user.getMainCity());
            }
            if(user.getMainAddress()!=null){
                existingUser.setMainAddress(user.getMainAddress());
            }

            return userRepository.save(existingUser);
        }
        else {
            return null;
        }
    }




    public List<User> searchUserByName(String name) {
        return userRepository.searchUserByNamesContaining(name);
    }

    public List<Object[]> getAddressByIdentificationNumber(String identificationNumber) {
        User user = userRepository.findByIdentificationNumber(identificationNumber);
        if(user != null) {
            // get the result from repository
            return userRepository.findAddress(user.getId());
        }
        return null;
    }


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User updateUserByIdentificationNumber(String identificationNumber, User user) {
        User existingUser = userRepository.findByIdentificationNumber(identificationNumber);

        if (existingUser != null) {
            if(user.getIdentificationType()!=null){
                existingUser.setIdentificationType(user.getIdentificationType());
            }
            if(user.getIdentificationNumber()!=null){
                existingUser.setIdentificationNumber(user.getIdentificationNumber());
            }
            if(user.getNames()!=null){
                existingUser.setNames(user.getNames());
            }
            if(user.getEmail()!=null){
                existingUser.setEmail(user.getEmail());
            }
            if(user.getCellPhone()!=null){
                existingUser.setCellPhone(user.getCellPhone());
            }
            if(user.getMainProvince()!=null){
                existingUser.setMainProvince(user.getMainProvince());
            }
            if(user.getMainCity()!=null){
                existingUser.setMainCity(user.getMainCity());
            }
            if(user.getMainAddress()!=null){
                existingUser.setMainAddress(user.getMainAddress());
            }

            return userRepository.save(existingUser);
        }
        else {
            return null;
        }
    }
}
