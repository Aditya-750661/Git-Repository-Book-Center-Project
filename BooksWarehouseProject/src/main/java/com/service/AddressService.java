package com.service;

import java.util.List;

import com.model.Address;
import com.model.User;

public interface AddressService {

	Address addUserAddress(long userId,Address address);

	User updateAddress(long userId,long addressId, Address address);

	List<Address> getAllAddresses();

	void deleteAddress(long addressId);

	
	
}
