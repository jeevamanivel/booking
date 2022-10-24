package com.sap.booking.controller.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sap.booking.model.BookingDTO;

@Repository
public interface BookingRepository extends CrudRepository<BookingDTO, Integer>{

	public BookingDTO findByBookingNo(String bookingNo);
}
