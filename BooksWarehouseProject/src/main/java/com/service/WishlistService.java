package com.service;

import java.util.List;

import com.model.Wishlist;

public interface WishlistService{

	List<Wishlist> getAllWishlists();

	Wishlist getWishlistById(long id);

	Wishlist createWishlist(Wishlist wishlist);

	Wishlist updateWishlist(long id, Wishlist wishlist);

	boolean deleteWishlist(long id);

}
