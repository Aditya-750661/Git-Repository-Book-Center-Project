package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Address;
import com.model.Order;
import com.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByusername(String username);

	
}
