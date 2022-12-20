package com.ascode.events.exceptions;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -7114487653197757339L;

	public BadRequestException(String message) {
		super(message);
	}
}
