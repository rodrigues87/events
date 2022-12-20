package com.ascode.events.exceptions;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7114487653197757339L;

	public NotFoundException(String message) {
		super(message);
	}
}
