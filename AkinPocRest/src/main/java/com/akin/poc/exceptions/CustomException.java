package com.akin.poc.exceptions;

public class CustomException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String errorMessage) {
        super(errorMessage);
    }
}
