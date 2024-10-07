package com.ac.hotel_service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
		
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException() {
		super("resource with given identifire is not found....!");
	}
}
