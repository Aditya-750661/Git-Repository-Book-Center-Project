package com.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookDescription;
    private String bookIsbn;
    private int bookPublicationYear;
    private String bookPublisher;
    private String bookLanguage;
    private String bookGenre;
    
    private String bookCondition;
    private Double bookPrice;
    private boolean isForRent;
    private Double BookRentalPrice;
    
    private boolean deleted;

    @ManyToOne(fetch =FetchType.EAGER,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "owner_user_id", referencedColumnName = "userId")
    private User bookOwner;

    @JsonIgnore
    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Review> bookReviews;
    
	public Book() {
		super();
		
	}
	
	public Book(long bookId, String bookTitle, String bookAuthor, String bookDescription, String bookIsbn,
			int bookPublicationYear, String bookPublisher, String bookLanguage, String bookGenre, String bookCondition,
			Double bookPrice, boolean isForRent, Double bookRentalPrice, boolean deleted, User bookOwner,
			List<Review> bookReviews) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookDescription = bookDescription;
		this.bookIsbn = bookIsbn;
		this.bookPublicationYear = bookPublicationYear;
		this.bookPublisher = bookPublisher;
		this.bookLanguage = bookLanguage;
		this.bookGenre = bookGenre;
		this.bookCondition = bookCondition;
		this.bookPrice = bookPrice;
		this.isForRent = isForRent;
		BookRentalPrice = bookRentalPrice;
		this.deleted = deleted;
		this.bookOwner = bookOwner;
		this.bookReviews = bookReviews;
	}




	public boolean isDeleted() {
		return deleted;
	}



	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}



	public boolean isForRent() {
		return isForRent;
	}



	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public int getBookPublicationYear() {
		return bookPublicationYear;
	}

	public void setBookPublicationYear(int bookPublicationYear) {
		this.bookPublicationYear = bookPublicationYear;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookLanguage() {
		return bookLanguage;
	}

	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public String getBookCondition() {
		return bookCondition;
	}

	public void setBookCondition(String bookCondition) {
		this.bookCondition = bookCondition;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public boolean getForRent() {
		return isForRent;
	}

	public void setForRent(boolean isForRent) {
		this.isForRent = isForRent;
	}

	public Double getBookRentalPrice() {
		return BookRentalPrice;
	}

	public void setBookRentalPrice(Double bookRentalPrice) {
		BookRentalPrice = bookRentalPrice;
	}

	public User getBookOwner() {
		return bookOwner;
	}

	public void setBookOwner(User bookOwner) {
		this.bookOwner = bookOwner;
	}

	public List<Review> getBookReviews() {
		return bookReviews;
	}

	public void setBookReviews(List<Review> bookReviews) {
		this.bookReviews = bookReviews;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", bookDescription=" + bookDescription + ", bookIsbn=" + bookIsbn + ", bookPublicationYear="
				+ bookPublicationYear + ", bookPublisher=" + bookPublisher + ", bookLanguage=" + bookLanguage
				+ ", bookGenre=" + bookGenre + ", bookCondition=" + bookCondition + ", bookPrice=" + bookPrice
				+ ", isForRent=" + isForRent + ", BookRentalPrice=" + BookRentalPrice + ", bookOwner=" + bookOwner
				+ ", bookReviews=" + bookReviews + "]";
	}
}

