package com.packaginganddelivery.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ExceptionPayLoad {
 private final String message;
 private final HttpStatus httpstatus;
 private final ZonedDateTime timestamp;
	
}
