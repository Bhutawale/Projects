package com.ecommerce.Exception;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException 
{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResouceNotFoundException(ResourceNotFoundException e)
	{
		String message = e.message;
		@SuppressWarnings("deprecation")
		ExceptionResponse er=new ExceptionResponse(message,new Date().toLocaleString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException e)
	{
		List<String> errors = e.getBindingResult()
			.getAllErrors()
				.stream()
					.map(error->error.getDefaultMessage())
					.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	@ExceptionHandler(APIException.class)
	public ResponseEntity<?> handleAPIException(APIException e)
	{
		String message=e.getMessage();
		@SuppressWarnings("deprecation")
		ExceptionResponse er=new ExceptionResponse(message,new Date().toLocaleString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
	}
}
