package com.sap.booking.service;

import com.sap.booking.model.BookingDTO;

public interface BookingService {
	
	public BookingDTO bookTickets(BookingDTO bookingDTO) throws Exception;
	
	public BookingDTO confirmBooking(String bookingRef) throws Exception;
	
	public BookingDTO cancelBooking(String bookingRef) throws Exception;

}
