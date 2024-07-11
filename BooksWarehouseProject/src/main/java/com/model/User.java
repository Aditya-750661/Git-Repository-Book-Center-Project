package com.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.model.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    
    @Lob
    @Column(length = 100000)
    private byte[] profilePicture;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER ,mappedBy = "bookOwner")
    @Column(name = "userId")
    private List<Book> books;
    
//    @JsonIgnore
    @OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "userId_fk",referencedColumnName = "userId")
    private List<Address> addresses;

//    @JsonIgnore
    @OneToMany(targetEntity = Review.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "userId_fk",referencedColumnName = "userId")
    private List<Review> reviews;

	public User() {
		super();	
	}

	public User(long userId, String username, String password, String email, String firstName, String lastName,
			String phoneNumber, byte[] profilePicture, LocalDateTime createdAt, LocalDateTime updatedAt,
			List<Address> addresses, List<Review> reviews) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.profilePicture = profilePicture;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.addresses = addresses;
		this.reviews = reviews;
	}
	
	public long getId() {
		return userId;
	}

	public void setId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", profilePicture=" + Arrays.toString(profilePicture) + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", addresses=" + addresses + ", reviews=" + reviews + "]";
	}
	
	
	
}
