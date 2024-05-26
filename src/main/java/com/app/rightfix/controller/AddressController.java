package com.app.rightfix.controller;

import com.app.rightfix.dto.response.ApiResponse;
import com.app.rightfix.entity.Address;
import com.app.rightfix.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address/api/v1")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createAddress(@RequestBody Address address) {
        addressService.saveAddress(address);
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", address);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    // Read
    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getAddressById(@PathVariable Long id) {
        Address address = addressService.getAddressById(id);
        if (address != null) {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", address);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } else {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok().body(addresses);
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        Address existingAddress = addressService.getAddressById(id);
        if (existingAddress != null) {
            address.setId(id);
            addressService.updateAddress(address);
            ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", address);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } else {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteAddress(@PathVariable Long id) {
        Address address = addressService.getAddressById(id);
        if (address != null) {
            addressService.deleteAddress(id);
            ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", null);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } else {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }
}
