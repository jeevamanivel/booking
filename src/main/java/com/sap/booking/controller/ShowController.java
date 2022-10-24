package com.sap.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sap.booking.ex.InputValidationException;
import com.sap.booking.model.Response;
import com.sap.booking.model.ShowDTO;
import com.sap.booking.model.ShowRequest;
import com.sap.booking.service.ShowService;
import com.sap.booking.util.ReqResUtil;

@Controller
@RequestMapping(value="/booking")
public class ShowController {
	
	@Autowired
	ShowService showService;
	
	/*Open to public*/
	@RequestMapping(value="/getshows",method=RequestMethod.POST)
	public Response<List<ShowDTO>> getShows(ShowRequest request, Pageable pageable) throws InputValidationException{
		return ReqResUtil.getSuccessResponse(showService.getShows(request/*,pageable*/));
	}

}
