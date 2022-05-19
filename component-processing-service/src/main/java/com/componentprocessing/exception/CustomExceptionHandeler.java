package com.componentprocessing.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import feign.FeignException;

@ControllerAdvice
public class CustomExceptionHandeler {

	@ExceptionHandler(value = { InvalidRequestDetails.class })
	public ResponseEntity<ExceptionPayLoad> handleInvalidInputException(Exception e) {
		HttpStatus badrequest = HttpStatus.BAD_REQUEST;
		ExceptionPayLoad payload = new ExceptionPayLoad(e.getMessage(), badrequest,
				ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));

		return new ResponseEntity<>(payload, badrequest);
	}

	@ExceptionHandler(value = { FeignException.class })
	public ResponseEntity<ExceptionPayLoad> handleFeignException(FeignException e) {
		HttpStatus badrequest = HttpStatus.valueOf(e.status());
		ExceptionPayLoad payload = new ExceptionPayLoad(e.getMessage(), badrequest,
				ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));

		return new ResponseEntity<>(payload, badrequest);
	}

	@ExceptionHandler(value = { feign.RetryableException.class })
	public ResponseEntity<ExceptionPayLoad> handleRetryableException(FeignException e) {
		HttpStatus badrequest = HttpStatus.valueOf(e.status());
		ExceptionPayLoad payload = new ExceptionPayLoad(e.getMessage(), badrequest,
				ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));

		return new ResponseEntity<>(payload, badrequest);
	}

	@ExceptionHandler(value = { ResponseStatusException.class })
	public ResponseEntity<ExceptionPayLoad> handleFeignException(ResponseStatusException e) {

		HttpStatus httpstatus = e.getStatus();
		ExceptionPayLoad payload = new ExceptionPayLoad(e.getReason(), httpstatus,
				ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));

		return new ResponseEntity<>(payload, httpstatus);
	}

	@ExceptionHandler(value = { MissingRequestHeaderException.class })
	public ResponseEntity<ExceptionPayLoad> handleHeaderException(MissingRequestHeaderException e) {
		HttpStatus badrequest = HttpStatus.BAD_REQUEST;
		ExceptionPayLoad payload = new ExceptionPayLoad(e.getMessage(), badrequest,
				ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));

		return new ResponseEntity<>(payload, badrequest);
	}
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ExceptionPayLoad> handleGenericException(Exception e) {
		HttpStatus badrequest = HttpStatus.BAD_REQUEST;
		ExceptionPayLoad payload = new ExceptionPayLoad(e.getMessage(), badrequest,
				ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));

		return new ResponseEntity<>(payload, badrequest);
	}

}
