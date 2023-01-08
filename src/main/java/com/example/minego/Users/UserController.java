package com.example.minego.Users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // get all users
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    // get user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        if (userService.getUserById(id) != null) {
            return ResponseEntity.ok(userService.getUserById(id));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


    // get user by identification number
    @GetMapping("/{identificationNumber}")
    public User getUserByIdentificationNumber(@PathVariable("identificationNumber") String identificationNumber){
        return userService.getUserByIdentificationNumber(identificationNumber);
    }


    // delete a user given the identification number
    @Transactional
    @Modifying
    @DeleteMapping("/delete/{identificationNumber}")
    public ResponseEntity<String> deleteUser(@PathVariable("identificationNumber") String identificationNumber) {
        String check = userService.deleteUser(identificationNumber);
        if (check.equals("User deleted")) {
            return ResponseEntity.ok(check);
        }
        else if (check.equals("User not found")) {
            return new ResponseEntity<>(check, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(check, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    // create a user
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.createUser(user);
        // get the ad

        if (user1 != null) {
            return new ResponseEntity<>(user1, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update a user
    @Transactional
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User user1 = userService.updateUser(id, user);
        if (user1 != null) {
            return ResponseEntity.ok(user1);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    // get address by identification number
    @GetMapping("/address/{identificationNumber}")
    public ResponseEntity<String> getAddressByIdentificationNumber(@PathVariable("identificationNumber") String identificationNumber){
        List<Object[]> address =  userService.getAddressByIdentificationNumber(identificationNumber);
        JSONObject jsonObject = new JSONObject();
        if (address != null) {
            try {
                jsonObject.put("mainAddress", address.get(0)[0]);
                jsonObject.put("mainProvince", address.get(0)[1]);
                jsonObject.put("mainState", address.get(0)[2]);
            } catch (JSONException e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(jsonObject.toString());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


}
