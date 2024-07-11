package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @ManyToOne()
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookId",referencedColumnName = "bookId")
    private Book book;

	public Cart() {
		
	}

	public Cart(long cartId, User user, Book book) {
		super();
		this.cartId = cartId;
		this.user = user;
		this.book = book;
	}

	public long getId() {
		return cartId;
	}

	public void setId(long cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", user=" + user + ", book=" + book + "]";
	}
    
}
