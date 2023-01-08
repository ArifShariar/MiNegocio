package com.example.minego.Addresses;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address updateAddress(Long id, Address address) {
        Address address1 = addressRepository.findById(id).orElse(null);
        if (address1 != null) {
            if (address.getCity() != null) {
                address1.setCity(address.getCity());
            }
            if (address.getProvince() != null) {
                address1.setProvince(address.getProvince());
            }
            if (address.getAddress() != null) {
                address1.setAddress(address.getAddress());
            }
            return addressRepository.save(address1);
        }
        else {
            return null;
        }
    }

    public String deleteAddress(Long id) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address != null) {
            addressRepository.delete(address);
            return "Address deleted";
        }
        else {
            return "Address not found";
        }
    }
}
