package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Address;
import com.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

	
	
}
