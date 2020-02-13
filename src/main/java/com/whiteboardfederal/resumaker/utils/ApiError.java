package com.whiteboardfederal.resumaker.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {

  private HttpStatus status;
  private String message;
  private List<String> errors;

  public ApiError(HttpStatus status, String message, List<String> errors) {
    super();
    this.setStatus(status);
    this.setMessage(message);
    this.setErrors(errors);
  }

  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public ApiError(HttpStatus status, String message, String error) {
    super();
    this.setStatus(status);
    this.setMessage(message);
    setErrors(Arrays.asList(error));
  }

}