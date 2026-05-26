package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleExcptionHandler {
	
	@ExceptionHandler(exception = EmailServiceException.class)
	public ResponseEntity<String> emailServiceException(EmailServiceException emailServiceException){
		return new ResponseEntity<String>(emailServiceException.getMessage(), emailServiceException.getStatus());
		
	}

}
