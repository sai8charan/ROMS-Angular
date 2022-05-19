package com.packaginganddelivery.exception;

public class InvalidInputDetailsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputDetailsException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidInputDetailsException(String message) {
		super(message);
	}

	
}
