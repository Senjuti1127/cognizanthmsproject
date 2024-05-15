package net.cts.hms.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorEntity> handleResourceNotFoundException(ResourceNotFoundException e){
		ErrorEntity error = new ErrorEntity(404, e.getMessage(), LocalDate.now());
		return new ResponseEntity<ErrorEntity>(error, HttpStatus.NOT_FOUND);
	}
	

}
