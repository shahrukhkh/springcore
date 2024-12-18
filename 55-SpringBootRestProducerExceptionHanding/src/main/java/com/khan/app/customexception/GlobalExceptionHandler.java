package com.khan.app.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> getException(ProductNotFoundException pnfe)
	{
		return new ResponseEntity<>(pnfe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
