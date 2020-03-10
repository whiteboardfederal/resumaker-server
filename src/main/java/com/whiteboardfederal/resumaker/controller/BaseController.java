package com.whiteboardfederal.resumaker.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.whiteboardfederal.resumaker.domain.ErrorInfo;
import com.whiteboardfederal.resumaker.exceptions.EntityNotFoundException;
import com.whiteboardfederal.resumaker.exceptions.InvalidFormException;


public class BaseController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)				// Defines the HTTP status code to return, 400 in this case.
	@ExceptionHandler(InvalidFormException.class)		// Tells it what Exception class to listen for, in this case we
														// need to create InvalidFormException for any time a user gives us bad data.
	@ResponseBody 										// Tells the method it's going to be writing to the response body (using Jackson,
														// a standard Java utility for handling JSON) to serialize the ErrorInfo 
														// object into JSON .
	public ErrorInfo handleBadRequest(HttpServletRequest req, InvalidFormException ex) {
		ex.printStackTrace();
		return new ErrorInfo(	HttpStatus.BAD_REQUEST.value(),
								ex.getMessage(),
								ex.getSolution());

	}
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	public ErrorInfo handleBadRequest(HttpServletRequest req, EntityNotFoundException ex) {
		ex.printStackTrace();
		return new ErrorInfo(	HttpStatus.NOT_FOUND.value(),
								ex.getMessage(),
								"Check the ID of the entity you're try to find to ensure it's valid");

	}
}
