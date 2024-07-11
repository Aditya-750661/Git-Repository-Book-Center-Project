package com.service;

import com.model.Book;
import com.model.User;
import com.model.Wishlist;
import com.dao.BookRepository;
import com.dao.UserRepository;
import com.dao.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private WishlistRepository wishlistRepository;

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Wishlist> getAllWishlists() {
		return wishlistRepository.findAll();
	}
	@Override
	public Wishlist getWishlistById(long id) {
	    System.out.println("inside service impl " + id);
	    return wishlistRepository.findById(id).orElse(null);
	}

	@Override
	public Wishlist createWishlist(Wishlist wishlist) {

		System.out.println(wishlist);

		Optional<Book> optionalBook = bookRepo.findById(wishlist.getBook().getBookId());


		Optional<User> optionalUser = userRepo.findById(wishlist.getUser().getId());

		if (optionalBook.isPresent() && optionalUser.isPresent()) {

			wishlist.setBook(optionalBook.get());
			wishlist.setUser(optionalUser.get());


			return wishlistRepository.save(wishlist);
		} else {

			return null;
		}
	}


	@Override
	public Wishlist updateWishlist(long UserId, Wishlist wishlist) {

		Optional<Wishlist> existingWishlist = wishlistRepository.findById(UserId);

		if (existingWishlist.isPresent()) {

			Wishlist w = existingWishlist.get();
			
			w.setBook(wishlist.getBook());
			return wishlistRepository.save(w);

		}
		return null;
	}

	@Override
	public boolean deleteWishlist(long id) {
		if (wishlistRepository.existsById(id)) {
			wishlistRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
