package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.Address;
import com.model.User;
import com.service.AddressService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/saveAddress/{userId}")
    public ResponseEntity<Address> addUserAddress(@PathVariable("userId") long userId,@RequestBody Address address) {
        try {
            Address add = addressService.addUserAddress(userId,address);
            return ResponseEntity.ok(add);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/update/{userId}/{addressId}")
    public ResponseEntity<User> updateAddress(@PathVariable("userId") long userId,@PathVariable("addressId") long addressId, @RequestBody Address address) {
        try {
            User user = addressService.updateAddress(userId, addressId,address);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete/{addressId}")
    
    public ResponseEntity<String> deleteAddress(@PathVariable("addressId") long addressId) {
        try {
        	
            addressService.deleteAddress(addressId);
            return ResponseEntity.ok("Address deleted successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete address");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }
}
