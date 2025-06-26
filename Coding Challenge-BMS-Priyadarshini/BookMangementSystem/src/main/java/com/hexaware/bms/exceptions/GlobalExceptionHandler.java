package com.hexaware.bms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {


@ExceptionHandler(BookNotFoundException.class)
public ResponseEntity<String> handleBookNotFound(BookNotFoundException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
}

@ExceptionHandler(BookAlreadyExistsException.class)
public ResponseEntity<String> handleBookAlreadyExists(BookAlreadyExistsException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
}

@ExceptionHandler(InvalidBookDataException.class)
public ResponseEntity<String> handleInvalidBookData(InvalidBookDataException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
}
}