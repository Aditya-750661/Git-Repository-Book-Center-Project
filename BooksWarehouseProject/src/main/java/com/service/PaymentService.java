package com.service;

import java.util.List;

import com.model.Payment;

public interface PaymentService {
	

	List<Payment> getAllPayments();

	boolean deletePayment(Long id);

	Payment updatePayment(Long id, Payment updatedPayment);

	Payment getPaymentById(Long id);

	Payment createPayment(Payment payment);

}
