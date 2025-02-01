package com.ecommerce.Exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException 
{
	String message;

	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
