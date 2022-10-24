package com.sap.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sap.booking.controller.dao.BookingRepository;
import com.sap.booking.ex.InputValidationException;
import com.sap.booking.model.BookingDTO;
import com.sap.booking.model.ShowDTO;
import com.sap.booking.service.BookingService;
import com.sap.booking.service.ShowService;
import com.sap.booking.util.BookingUtil;

public class BookingServiceImpl implements BookingService{
	
	@Autowired
	ShowService showService;
	
	@Autowired
	BookingRepository bookingRepo;

	//Do null checks wherever required
	@Transactional(rollbackFor = Exception.class)
	public BookingDTO bookTickets(BookingDTO bookingDTO) throws Exception {
		if(bookingDTO!=null /*Other mandatory fields validation*/) {
			ShowDTO showDTO = showService.getShowDetails(bookingDTO.getShowId());
			if(seatsAlreadyBlocked(showDTO.getMovieId(), showDTO.getPartnerId(), showDTO.getHall(), bookingDTO.getSeats())) {
				throw new Exception("These seats are not available for booking");
			}
			addSeatsToBlockedSeats(showDTO.getMovieId(), showDTO.getPartnerId(), showDTO.getHall(), bookingDTO.getSeats());
			bookingDTO = createBooking(bookingDTO);
			showService.blockSeats(showDTO.getId(), bookingDTO.getSeats());
		}
		else {
			throw new InputValidationException();
		}
		return bookingDTO;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public BookingDTO confirmBooking(String bookingRef) throws Exception {
		BookingDTO bookingDTO = bookingRepo.findByBookingNo(bookingRef);
		if(bookingDTO!=null){
			ShowDTO showDTO = showService.getShowDetails(bookingDTO.getShowId());
			bookingDTO.setStatus("BOOKED");
			bookingDTO = bookingRepo.save(bookingDTO);
			removeSeatsFromBlockedSeats(showDTO.getMovieId(), showDTO.getPartnerId(), showDTO.getHall(), bookingDTO.getSeats());
		}
		else {
			throw new Exception("Invalid Booking Number");
		}
		return bookingDTO;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public BookingDTO cancelBooking(String bookingRef) throws Exception {
		BookingDTO bookingDTO = bookingRepo.findByBookingNo(bookingRef);
		if(bookingDTO!=null){
			ShowDTO showDTO = showService.getShowDetails(bookingDTO.getShowId());
			bookingDTO.setStatus("CANCELLED");
			bookingDTO = bookingRepo.save(bookingDTO);
			removeSeatsFromBlockedSeats(showDTO.getMovieId(), showDTO.getPartnerId(), showDTO.getHall(), bookingDTO.getSeats());
			showService.unblockSeats(showDTO.getId(), bookingDTO.getSeats());
		}
		else {
			throw new Exception("Invalid Booking Number");
		}
		return bookingDTO;
	}
	
	private BookingDTO createBooking(BookingDTO bookingDTO) {
		bookingDTO.setBookingNo(BookingUtil.generateBookingId());
		bookingDTO.setStatus("CREATED");
		return bookingRepo.save(bookingDTO);
	}
	
	private boolean seatsAlreadyBlocked(int movieId, int partnerId, int hall, String seats) {
		//Check in Cache and return result accordingly
		return false;
	}
	
	private void addSeatsToBlockedSeats(int movieId, int partnerId, int hall, String seats) {
		synchronized(this) {
			//Add in cache
		}
	}
	
	private void removeSeatsFromBlockedSeats(int movieId, int partnerId, int hall, String seats) {
		synchronized(this) {
			//Remove from cache
		}
	}

}
