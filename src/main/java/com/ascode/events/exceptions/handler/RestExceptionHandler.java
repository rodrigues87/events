package com.ascode.events.exceptions.handler;


import com.ascode.events.constants.ErrorCodes;
import com.ascode.events.exceptions.BadRequestException;
import com.ascode.events.exceptions.ConflictException;
import com.ascode.events.exceptions.ExceptionResponse;
import com.ascode.events.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        log.error("An unexpected error occur: {}", ex.getMessage(), ex);

        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.INTERNAL_SERVER_ERROR, ex.getMessage());

        request.getDescription(false);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("Invalid Arguments: {} ", ex.getMessage(), ex);

        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.INVALID_REQUEST, ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        log.error("MethodArgumentNotValid: {} ", ex.getMessage(), ex);

        final List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        List<String> errors = fieldErrors.stream()
                .map(f -> String.format("%s : %s",f.getField(),f.getDefaultMessage()))
                .collect(Collectors.toList());

        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.VALIDATION_FAILED, errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> onConstraintValidationException(final ConstraintViolationException ex) {
        log.error("onConstraintValidationException: {}", ex.getMessage(), ex);

        final List<String> errors = ex.getConstraintViolations()
                .stream()
                .map(c -> String.format("%s : %s", c.getPropertyPath(), c.getMessage()))
                .collect(Collectors.toList());

        final ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.INVALID_REQUEST, errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
    

    @ExceptionHandler(ConflictException.class)
    protected ResponseEntity<Object> handleConflictException(ConflictException ex) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.CONFLICT, ex.getMessage());

        log.info("RestExceptionHandler.handleConflictException - class: {}, message: {}", ex.getClass(), ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponse);

    }
    
    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
       
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.NOT_FOUND, ex.getMessage());
        log.info("RestExceptionHandler.handleNotFoundException - class: {}, message: {}", ex.getClass(), ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);

    }
    
    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        log.info("onConflictException: {} ", ex.getClass(), ex.getMessage());
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.BAD_REQUEST, ex.getMessage());
        log.info("RestExceptionHandler.handleBadRequestException - class: {}, message: {}", ex.getClass(), ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);

    }

}