package com.appdevlopment.app.ws.exceptions;

public class UserServiceException extends RuntimeException {
	private static final long serialVersionUID=2326945656L;
	
	public UserServiceException(String message)
	{
		super(message);
	}

}
