package com.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "orderId")
    private Order order;

    private double amount;
    private LocalDateTime paymentDate;
    private String paymentType;
    private String accountNumber;
	
    public Payment() {
		super();

	}

	public Payment(long id, Order order, double amount, LocalDateTime paymentDate, String paymentType,
			String accountNumber) {
		super();
		this.id = id;
		this.order = order;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
		this.accountNumber = accountNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", order=" + order + ", amount=" + amount + ", paymentDate=" + paymentDate
				+ ", paymentType=" + paymentType + ", accountNumber=" + accountNumber + "]";
	}
    
    

}
