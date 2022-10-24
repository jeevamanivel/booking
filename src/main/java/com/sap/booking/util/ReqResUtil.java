package com.sap.booking.util;

import com.sap.booking.model.Response;

public class ReqResUtil {
	
	public static <T> Response<T> getSuccessResponse(T t) {
		Response<T> response = new Response<T>();
		response.setResponse(t);
		return response;
	}

}
