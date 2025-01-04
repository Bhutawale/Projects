package com.blog.exception;

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
	public ResponseEntity<?> UserNotFoundException(ResourceNotFoundException resourceNotFoundException)
	{
		String message=resourceNotFoundException.getMessage();
		@SuppressWarnings("deprecation")
		ApiResponse respone=new ApiResponse(message, new Date().toLocaleString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respone);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex)
	{
			List<String> errors = ex.getBindingResult()
					.getAllErrors()
					.stream()
					.map(error->error.getDefaultMessage())
					.collect(Collectors.toList());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
}
