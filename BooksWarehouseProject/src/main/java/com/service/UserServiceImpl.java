package com.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AddressRepository;
import com.dao.OrderRepository;
import com.dao.UserRepository;
import com.model.Address;
import com.model.Order;
import com.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public User registerUse(User user) {
		return userRepo.save(user);
	}


	@Override
	public User findUserById(long id) {
		return userRepo.findById(id).orElse(null);
	}


	@Override
	public boolean loginCredentials(String username,String password) {
		
		User u = userRepo.findByusername(username);
		
		if(u != null && u.getPassword().equals(password))
			return true; 
		else 
			return false;		
	}


	@Override
	public User updateUser(long id, User user) {
		
	Optional<User> userOptional = userRepo.findById(id);
		
		if(userOptional.isPresent()) {
			User existingUser = userOptional.get();
			
			existingUser.setEmail(user.getEmail());
			existingUser.setUsername(user.getUsername());
			
			return userRepo.save(existingUser);
		}
	
		return null;
	}
	
	public void delete(long id) {
		 userRepo.deleteById(id);
	}
}
