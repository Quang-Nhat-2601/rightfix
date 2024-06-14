package com.app.rightfix.controller;

import com.app.rightfix.dto.Response;
import com.app.rightfix.entity.Address;
import com.app.rightfix.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address/api/v1")
@CrossOrigin(origins = "*")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<Response> createAddress(@RequestBody Address address) {
        addressService.saveAddress(address);
        Response response = new Response(HttpStatus.OK.value(), "successfully", address);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Read
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getAddressById(@PathVariable Long id) {
        Address address = addressService.getAddressById(id);
        if (address != null) {
            Response response = new Response(HttpStatus.OK.value(), "successfully", address);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok().body(addresses);
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        Address existingAddress = addressService.getAddressById(id);
        if (existingAddress != null) {
            address.setId(id);
            addressService.updateAddress(address);
            Response response = new Response(HttpStatus.OK.value(), "successfully", address);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

     //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteAddress(@PathVariable Long id) {
        Address address = addressService.getAddressById(id);
        if (address != null) {
            addressService.deleteAddress(id);
            Response response = new Response(HttpStatus.OK.value(), "successfully", null);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
