package com.sap.booking.service;

public interface PaymentService {
	
	public /*PaymentDTO*/void updatePayment(/*PaymentDTO paymentDTO*/) throws Exception;
	
	public /*PaymentDTO*/void refreshPaymentStatus(/*PaymentDTO paymentDTO*/) throws Exception;

}
