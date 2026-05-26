package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class EmailServiceException extends RuntimeException {

	private String message;
	private HttpStatus statusCode;

	public String getMessage() {
		return message;

	}

	public HttpStatus getStatus() {
		return statusCode;

	}

	public EmailServiceException(String message , HttpStatus httpStatus) {
		this.message = message;
		this.statusCode = httpStatus;
	}
}
