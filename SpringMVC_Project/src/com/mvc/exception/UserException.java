package com.mvc.exception;

public class UserException extends Exception {
	private static final long serialVersionUID = 1L;
	private String exceptionMessage;
	
	public UserException(String exceptionMessage) {
		super(exceptionMessage);
		this.exceptionMessage = exceptionMessage;
	}
	
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}
