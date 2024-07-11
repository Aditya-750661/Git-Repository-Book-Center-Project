package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AddressRepository;
import com.dao.UserRepository;
import com.model.Address;
import com.model.User;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	@Transactional
    public Address addUserAddress(long userId, Address address) {
        // Fetch user from the repository and ensure it's managed
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Set the user to the address
        address.setUser(user);

        // Save the address
        addressRepo.save(address);

        return address;
    }

	@Override
	public User updateAddress(long userId, long addressId,Address address) {
		Address add = addressRepo.findById(addressId).orElse(null);

		User user = userRepo.findById(userId).orElse(null);

		if (user == null && add == null) {
			throw new IllegalArgumentException("User not found");
		}


		if (add == null ||!Long.valueOf(add.getUser().getId()).equals(userId)) {
			throw new IllegalArgumentException("Address not found for the user");
		}

		add.setAddressLine1(address.getAddressLine1());
		add.setAddressLine2(address.getAddressLine2());
		add.setCity(address.getCity());
		add.setState(address.getState());
		add.setCountry(address.getCountry());
		add.setZipCode(address.getZipCode());

		addressRepo.save(add);

		return user;
	}

	@Override
	public void deleteAddress(long id) {
		addressRepo.deleteById(id);
	}
	@Override
	public List<Address> getAllAddresses() {


		return addressRepo.findAll();
	}

}
