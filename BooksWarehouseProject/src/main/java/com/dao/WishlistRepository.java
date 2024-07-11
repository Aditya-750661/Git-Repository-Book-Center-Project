package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Wishlist;

public interface WishlistRepository  extends JpaRepository<Wishlist, Long> {

}
