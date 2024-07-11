package com.controller;

import com.model.Wishlist;
import com.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlists")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;

	@GetMapping("/getall")
	public ResponseEntity<List<Wishlist>> getAllWishlists() {
		List<Wishlist> wishlists = wishlistService.getAllWishlists();
		return ResponseEntity.ok(wishlists);
	}

	@GetMapping("/getById/{id}")
	 public ResponseEntity<Wishlist> getWishlistById(@PathVariable long id) {
        Wishlist wishlist = wishlistService.getWishlistById(id);
        if (wishlist != null) {
            return ResponseEntity.ok(wishlist);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
	@PostMapping("/save")
	public ResponseEntity<Wishlist> createWishlist(@RequestBody Wishlist wishlist) {
		Wishlist createdWishlist = wishlistService.createWishlist(wishlist);
		return ResponseEntity.ok(createdWishlist);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Wishlist> updateWishlist(@PathVariable long id, @RequestBody Wishlist wishlist) {
		Wishlist updatedWishlist = wishlistService.updateWishlist(id, wishlist);
		if (updatedWishlist != null) {
			return ResponseEntity.ok(updatedWishlist);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteWishlist(@PathVariable long id) {
		if (wishlistService.deleteWishlist(id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
