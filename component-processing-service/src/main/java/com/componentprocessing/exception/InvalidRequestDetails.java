package com.componentprocessing.exception;

public class InvalidRequestDetails extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidRequestDetails(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidRequestDetails(String message) {
		super(message);
	}


	
	

}
