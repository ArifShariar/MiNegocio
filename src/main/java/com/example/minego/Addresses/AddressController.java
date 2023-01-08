package com.example.minego.Addresses;


import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // get all addresses
    @GetMapping("/all")
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    // get address by id
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Long id){
        if (addressService.getAddressById(id) != null) {
            return ResponseEntity.ok(addressService.getAddressById(id));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


    // create a new address
    @PostMapping("/create")
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address address1 = addressService.createAddress(address);
        if (address1 != null) {
            return ResponseEntity.ok(address1);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    // update an address
    @Transactional
    @PutMapping("/update/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("id") Long id, @RequestBody Address address) {
        Address address1 = addressService.updateAddress(id, address);
        if (address1 != null) {
            return ResponseEntity.ok(address1);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    // delete an address
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("id") Long id) {

        String check = addressService.deleteAddress(id);

        if (check.equals("Address deleted")) {
            return ResponseEntity.ok(check);
        }
        else if (check.equals("Address not found")) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
}
