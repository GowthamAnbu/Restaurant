package com.gowtham.exception;

public class SeatFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SeatFoundException(String message,Throwable e) {
		super(message,e);
	}
	
	public SeatFoundException(String message) {
		super(message);
	}
	
	
}
