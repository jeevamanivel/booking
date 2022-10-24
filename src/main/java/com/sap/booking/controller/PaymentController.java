package com.sap.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sap.booking.service.PaymentService;

@Controller
@RequestMapping(value="/booking")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping(value="/updatePayment",method=RequestMethod.POST)
	public /*PaymentDTO*/void updatePayment(/*PaymentDTO paymentDTO*/) throws Exception {
		paymentService.updatePayment();
	}
	
	@RequestMapping(value="/refreshPaymentStatus",method=RequestMethod.POST)
	public /*PaymentDTO*/void refreshPaymentStatus(/*PaymentDTO paymentDTO*/) throws Exception {
		paymentService.refreshPaymentStatus();
	}

}
