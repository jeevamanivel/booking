package com.sap.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sap.booking.model.BookingDTO;
import com.sap.booking.model.Response;
import com.sap.booking.service.BookingService;
import com.sap.booking.util.ReqResUtil;

@Controller
@RequestMapping(value="/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	/*Open to public*/
	@RequestMapping(value="/bookTickets",method=RequestMethod.POST)
	public Response<BookingDTO> bookTickets(BookingDTO bookingDTO) throws Exception {
		return ReqResUtil.getSuccessResponse(bookingService.bookTickets(bookingDTO));
	}
	
	@RequestMapping(value="/confirmBooking",method=RequestMethod.POST)
	public Response<BookingDTO> confirmBooking(String bookingRef) throws Exception {
		return ReqResUtil.getSuccessResponse(bookingService.confirmBooking(bookingRef));
	}

}
