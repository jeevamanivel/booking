package com.sap.booking.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sap.booking.controller.dao.ShowRepository;
import com.sap.booking.ex.InputValidationException;
import com.sap.booking.model.ShowDTO;
import com.sap.booking.model.ShowRequest;
import com.sap.booking.service.ShowService;
import com.sap.booking.util.DateUtil;

@Service
public class ShowServiceImpl implements ShowService{
	
	@Autowired
	ShowRepository showRepo;

	public List<ShowDTO> getShows(ShowRequest request) throws InputValidationException {
		if(request!=null && !StringUtils.isEmpty(request.getCity()) &&
				request.getMovieId()!=0 && DateUtil.isTodayOrFutureDate(request.getDate())) {
			List<ShowDTO> showList = showRepo.getShows(request.getMovieId(), request.getCity(), request.getDate());
			/*
			 * Transformation if any
			 * */
			return showList;
		}
		else {
			throw new InputValidationException("Insufficient details to get shows");
		}
	}

	public ShowDTO getShowDetails(int showId) {
		return showRepo.findById(showId).get();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public ShowDTO blockSeats(int showId, String seats) {
		/*return showRepo.blockSeats(showId, seats);*/
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public ShowDTO unblockSeats(int showId, String seats) {
		/*return showRepo.unblockSeats(showId, seats);*/
		return null;
	}
}
