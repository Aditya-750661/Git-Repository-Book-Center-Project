package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    private int rating;
    private String comment;
    private LocalDateTime reviewDate;
	
    public Review() {
		super();
		
	}

	public Review(long reviewId, User user, Book book, int rating, String comment, LocalDateTime reviewDate) {
		super();
		this.reviewId = reviewId;
		this.user = user;
		this.book = book;
		this.rating = rating;
		this.comment = comment;
		this.reviewDate = reviewDate;
	}

	public long getId() {
		return reviewId;
	}

	public void setId(long reviewId) {
		this.reviewId = reviewId;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDateTime reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", user=" + user + ", book=" + book + ", rating=" + rating + ", comment=" + comment
				+ ", reviewDate=" + reviewDate + "]";
	}
    
}

