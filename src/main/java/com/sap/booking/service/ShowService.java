package com.sap.booking.service;

import java.util.List;

import com.sap.booking.ex.InputValidationException;
import com.sap.booking.model.ShowDTO;
import com.sap.booking.model.ShowRequest;

public interface ShowService {
	
	public List<ShowDTO> getShows(ShowRequest request) throws InputValidationException;
	
	public ShowDTO getShowDetails(int showId);
	
	public ShowDTO blockSeats(int showId, String seats);
	
	public ShowDTO unblockSeats(int showId, String seats);

}
