package com.app.rightfix.dao;

import com.app.rightfix.entity.Address;

import java.util.List;

public interface AddressDAO {
    // create Address
    void save(Address address);

    // Search by id
    Address findById(Long id);

    List<Address> findAll();

    // Update
    void update(Address address);

    void delete(Address address);

}
