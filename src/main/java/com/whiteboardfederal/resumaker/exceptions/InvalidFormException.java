package com.whiteboardfederal.resumaker.exceptions;

public class InvalidFormException extends Exception {
	private String solution;
	
	public InvalidFormException(String msg, String solution, Throwable ex) {
		super(msg, ex);
		setSolution(solution);
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}
	
}
