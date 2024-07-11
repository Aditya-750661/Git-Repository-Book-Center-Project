package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Cart;

public interface CartService {

	List<Cart> getAllCarts();

	Optional<Cart> getCartById(long id);

	Cart createCart(long bookId,Cart cart);

	Cart updateCart(long id, Cart cartDetails);

	boolean deleteCart(long id);

}
