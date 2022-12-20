package com.ascode.events.exceptions;

import java.io.Serial;

public class NotFoundException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -7114487653197757339L;

	public NotFoundException(String message) {
		super(message);
	}
}
