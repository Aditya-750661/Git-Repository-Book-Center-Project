package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Wishlist {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookId",referencedColumnName = "bookId")
    private Book book;

	public Wishlist() {
	
	}

	public Wishlist(long id, User user, Book book) {
		super();
		this.id = id;
		this.user = user;
		this.book = book;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return "Wishlist [id=" + id + ", user=" + user + ", book=" + book + ", getId()=" + getId() + ", getUser()="
				+ getUser() + ", getBook()=" + getBook() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
    
}
