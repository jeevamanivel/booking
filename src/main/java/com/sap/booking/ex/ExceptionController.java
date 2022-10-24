package com.sap.booking.ex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sap.booking.constants.Constants;
import com.sap.booking.model.Error;
import com.sap.booking.model.Response;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = Exception.class)
    public <T> ResponseEntity<Response<T>> genericException(Exception exception) {
		Response<T> response = new Response<T>();
		Error error = new Error();
		error.setCode(Constants.T_001);
		error.setMessage("Technical Exception");
		List<Error> errors = new ArrayList<Error>();
		errors.add(error);
		response.setErrors(errors);
		return new ResponseEntity<Response<T>>(response, HttpStatus.OK);
    }

}
