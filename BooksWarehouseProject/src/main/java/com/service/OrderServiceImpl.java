package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookRepository;
import com.dao.OrderRepository;
import com.dao.UserRepository;
import com.model.Book;
import com.model.Order;
import com.model.User;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired 
	private OrderRepository orderRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BookRepository bookRepo;


	@Override
	public Order buyOrder(Order order) {
		User buyer = userRepo.findById(order.getBuyer().getId()).orElse(null);
		User seller = userRepo.findById(order.getSeller().getId()).orElse(null);
		Book book = bookRepo.findById(order.getBook().getBookId()).orElse(null);

		if (buyer == null) {
			throw new IllegalArgumentException("Buyer not found");
		}
		if (seller == null) {
			throw new IllegalArgumentException("Seller not found");
		}
		if (book == null) {
			throw new IllegalArgumentException("Book not found");
		}

		order.setBuyer(buyer);
		order.setSeller(seller);
		order.setBook(book);

		return orderRepo.save(order);
	}


	@Override
	public Order buyOnRentOrder(long buyerId,long sellerId,long bookId, Order order) {

		User buyer = userRepo.findById(buyerId).orElse(null);
		User seller = userRepo.findById(sellerId).orElse(null);
		Book book = bookRepo.findById(bookId).orElse(null);

		System.out.println(order);


		if (buyer == null || seller == null || book == null ) {
			System.out.println("null found");
			return null;
		}	
		order.setBuyer(buyer);
		order.setSeller(seller);
		order.setBook(book);

		System.out.println("not returning order");
		return orderRepo.save(order);
	}

	@Override
	public void deleteOrder(long orderId) {
		orderRepo.deleteById(orderId);
	}

	public Order getOrderById(long orderId) {
		return orderRepo.findById(orderId).orElse(null);
	}
}