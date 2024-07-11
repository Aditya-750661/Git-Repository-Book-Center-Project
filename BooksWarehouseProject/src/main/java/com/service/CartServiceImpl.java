package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Book;
import com.model.Cart;
import com.model.User;
import com.dao.BookRepository;
import com.dao.CartRepository;
import com.dao.UserRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	
	@Override
	public List<Cart> getAllCarts() {
		return cartRepository.findAll();
	}

	@Override
	public Optional<Cart> getCartById(long id) {
		return cartRepository.findById(id);
	}

	@Override
	public Cart createCart(long bookId, Cart cart) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		Optional<User> optionalUser = userRepository.findById(cart.getUser().getId());

		if (optionalBook.isPresent() && optionalUser.isPresent()) {
			Book book = optionalBook.get();
			User user = optionalUser.get();

			cart.setUser(user);
			cart.setBook(book);
			return cartRepository.save(cart);
		}
		return null;
	}

	@Override
	public Cart updateCart(long id, Cart cartDetails) {
		Optional<Cart> cartOptional = cartRepository.findById(id);

		if (cartOptional.isPresent()) {
			Cart cart = cartOptional.get();
			cart.setUser(cartDetails.getUser());
			cart.setBook(cartDetails.getBook());
			return cartRepository.save(cart);
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteCart(long id) {
		Optional<Cart> cartOptional = cartRepository.findById(id);

		if (cartOptional.isPresent()) {
			cartRepository.delete(cartOptional.get());
			return true;
		} else {
			return false;
		}
	}

}
