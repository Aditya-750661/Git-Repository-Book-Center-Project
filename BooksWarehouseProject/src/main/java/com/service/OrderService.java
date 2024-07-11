package com.service;

import com.model.Order;

public interface OrderService {
	
	public Order buyOrder(Order o);

	public Order buyOnRentOrder(long buyerId,long sellerId,long bookId, Order order);
	
	public void deleteOrder(long orderId);
	public Order getOrderById(long orderId);
	
}
