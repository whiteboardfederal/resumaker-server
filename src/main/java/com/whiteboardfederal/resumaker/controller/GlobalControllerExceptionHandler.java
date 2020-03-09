package com.whiteboardfederal.resumaker.controller;

import com.whiteboardfederal.resumaker.utils.ApiError;
import com.whiteboardfederal.resumaker.utils.EntityMissingException;

import org.hibernate.proxy.EntityNotFoundDelegate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler{
  
  @ExceptionHandler(EntityMissingException.class)
  public ResponseEntity<Object> entityNotFound(final EntityMissingException e) {
    System.out.println("Called");
    ApiError err = new ApiError(HttpStatus.NOT_FOUND, e.getMessage(), e.getMessage());
    e.printStackTrace();
    return new ResponseEntity<Object>(err, new HttpHeaders(), err.getStatus());
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Object> fallbackHandler(final RuntimeException e) {
    System.out.println("Called");
    ApiError err = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "An unhandled runtime exception occurred", e.getMessage());
    e.printStackTrace();
    return new ResponseEntity<Object>(err, new HttpHeaders(), err.getStatus());
  }


}