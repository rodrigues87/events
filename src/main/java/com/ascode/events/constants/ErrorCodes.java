package com.ascode.events.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum ErrorCodes {

    INTERNAL_SERVER_ERROR("Internal server error"),
    INVALID_REQUEST("Invalid request"),
    VALIDATION_FAILED("Validation failed"),
    NOT_FOUND("Not found"),
    BAD_REQUEST("Bad request"),
    CONFLICT("Conflict");

    private final String message;

}
