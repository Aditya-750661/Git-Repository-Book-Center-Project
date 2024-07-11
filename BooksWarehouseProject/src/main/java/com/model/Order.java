package com.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "userId")
    private User buyer;

    @ManyToOne
    @JoinColumn(referencedColumnName = "userId")
    private User seller;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(referencedColumnName = "bookId")
    private Book book;

    private String rentalPeriod;
    private String orderType;
    private LocalDateTime orderDate;
    private String deliveryStatus;
    private String transactionType;

    @OneToOne(mappedBy = "order")
    private Payment payment;

	public Order() {

	}

	public Order(long orderId, User buyer, User seller, Book book, String rentalPeriod, String orderType,
			LocalDateTime orderDate, String deliveryStatus, String transactionType, Payment payment) {
		super();
		this.orderId = orderId;
		this.buyer = buyer;
		this.seller = seller;
		this.book = book;
		this.rentalPeriod = rentalPeriod;
		this.orderType = orderType;
		this.orderDate = orderDate;
		this.deliveryStatus = deliveryStatus;
		this.transactionType = transactionType;
		this.payment = payment;
	}



	public long getId() {
		return orderId;
	}

	public void setId(long orderId) {
		this.orderId = orderId;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getRentalPeriod() {
		return rentalPeriod;
	}

	public void setRentalPeriod(String rentalPeriod) {
		this.rentalPeriod = rentalPeriod;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	public long getOrderId() {
		return orderId;
	}



	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}



	public String getTransactionType() {
		return transactionType;
	}



	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}



	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", buyer=" + buyer + ", seller=" + seller + ", book=" + book + ", rentalPeriod="
				+ rentalPeriod + ", orderType=" + orderType + ", orderDate=" + orderDate + ", deliveryStatus="
				+ deliveryStatus + ", payment=" + payment + "]";
	}    
}
