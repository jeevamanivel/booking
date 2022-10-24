package com.sap.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sap.booking.service.BookingService;
import com.sap.booking.service.PaymentGatewayService;
import com.sap.booking.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	PaymentGatewayService razorPayService;

	@Transactional(rollbackFor = Exception.class)//Rollback for checked exceptions
	public /*PaymentDTO*/void updatePayment(/*PaymentDTO paymentDTO*/) throws Exception{
		/*Basic Validation*/
		//updatePaymentInRepo();//Update payment details to DB
		boolean success = true; //Derive this from input
		if(success) {
			bookingService.confirmBooking(/*bookingRef*/null);
		}
		else {
			bookingService.cancelBooking(/*bookingRef*/null);
		}
	}
	
	@Transactional(rollbackFor = Exception.class)//Rollback for checked exceptions
	public /*PaymentDTO*/void refreshPaymentStatus(/*PaymentDTO paymentDTO*/) throws Exception{
		/*Basic Validation*/
		razorPayService.getPaymentStatus();
		//updatePaymentInRepo();//Update payment details to DB
		boolean success = true; //Derive this from razorpay result
		if(success) {
			bookingService.confirmBooking(/*bookingRef*/null);
		}
		else {
			bookingService.cancelBooking(/*bookingRef*/null);
		}
		
	}

}
