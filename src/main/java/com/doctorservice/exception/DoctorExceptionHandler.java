package com.doctorservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.doctorservice.entity.ErrorResponse;

@ControllerAdvice
public class DoctorExceptionHandler {
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(DoctorNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); // get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // 404 Not found
	}

	@ExceptionHandler(DoctorExistsException.class)
	public ResponseEntity<ErrorResponse> handleException(DoctorExistsException exception) {
		ErrorResponse error = new ErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); // get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // 404 Not found
	}

}
