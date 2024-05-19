package com.app.rightfix.service.impl;

import com.app.rightfix.dao.AddressDAO;
import com.app.rightfix.entity.Address;
import com.app.rightfix.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressDAO addressDAO;

    @Autowired
    public AddressServiceImpl(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Override
    public void saveAddress(Address address) {
        addressDAO.save(address);
    }

    @Override
    public Address getAddressById(Long id) {
        return addressDAO.findById(id);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressDAO.findAll();
    }

    @Override
    public void updateAddress(Address address) {
        addressDAO.update(address);
    }

    @Override
    public void deleteAddress(Long id) {
        Address address = addressDAO.findById(id);
        if (address != null) {
            addressDAO.delete(address);
        }
    }
}
