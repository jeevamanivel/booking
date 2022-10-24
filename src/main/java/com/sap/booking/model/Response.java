package com.sap.booking.model;

import java.util.List;

public class Response<T> {
	
	private T response;
	private List<Error> errors;
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	public List<Error> getErrors() {
		return errors;
	}
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

}
