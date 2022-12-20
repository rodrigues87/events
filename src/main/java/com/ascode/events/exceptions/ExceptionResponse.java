package com.ascode.events.exceptions;

import com.ascode.events.constants.ErrorCodes;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Getter
@EqualsAndHashCode
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private String message;
    private List<String> details;

    public ExceptionResponse(final ErrorCodes errorCode, final String details) {
        this.code = errorCode.name();
        this.message = errorCode.getMessage();
        this.details = Collections.singletonList(details);
    }

    public ExceptionResponse(final ErrorCodes errorCode, final List<String> details) {
        this.code = errorCode.name();
        this.message = errorCode.getMessage();
        this.details = details;
    }

}

