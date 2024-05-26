package com.app.rightfix.service;

import com.app.rightfix.entity.Address;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

public interface AddressService {

    // Create
    void saveAddress(Address address);

    // Read
    Address getAddressById(Long id);

    List<Address> getAllAddresses();

    // Update
    void updateAddress(Address address);

    // Delete
    void deleteAddress(Long id);
}
