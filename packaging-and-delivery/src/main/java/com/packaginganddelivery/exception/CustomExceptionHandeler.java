package com.packaginganddelivery.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandeler {
	
	@ExceptionHandler(value= {InvalidInputDetailsException.class})
	public ResponseEntity<ExceptionPayLoad> handleInvalidInputException(InvalidInputDetailsException e)
	{   
		HttpStatus badrequest = HttpStatus.BAD_REQUEST;
		ExceptionPayLoad payload = new ExceptionPayLoad(e.getMessage(), 
				badrequest, ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));
		
		
		return new ResponseEntity<>(payload,badrequest);
	}

}
