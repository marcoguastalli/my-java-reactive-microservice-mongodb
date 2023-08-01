package net.marco27.api.rx.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import net.marco27.api.rx.exception.ConnectionException;
import net.marco27.api.rx.exception.DocumentNotFoundException;

/** Handler fot Exceptions */
@RestControllerAdvice
@Slf4j
public class ApiExceptionHandlerController {

    ResponseEntity<String> handleError(final HttpStatus status, final Exception e) {
        log.error("Exception: ", e);
        return ResponseEntity.status(status).body(e.getMessage());
    }

    @ExceptionHandler({ IllegalArgumentException.class })
    public ResponseEntity<String> handleNotFoundException(final IllegalArgumentException e) {
        return handleError(BAD_REQUEST, e);
    }

    @ExceptionHandler({ ConnectionException.class })
    public ResponseEntity<String> handleContributorsApiConnectionException(final ConnectionException e) {
        return handleError(INTERNAL_SERVER_ERROR, e);
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler({ DocumentNotFoundException.class })
    public void handle(DocumentNotFoundException e) {
        log.error("Document not found: ", e);
    }
}
