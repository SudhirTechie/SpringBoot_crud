package com.sudhir.market.exception;

public class RecordNotFoundException extends Exception{
	public RecordNotFoundException() {
		
	}
	
	public RecordNotFoundException(String message) {
		super(message);
	}
	
	public RecordNotFoundException(String message,Throwable t) {
		super(message,t);
	}
	
	

}
