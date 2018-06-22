package com.propertyhandler;

/*
 * @Author: Shrikrishna Prabhumirashi
 * Date Created: 12-Jun-2018
 * */

public final class AppPropertiesException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AppPropertiesException() {
		super();
	}

	public AppPropertiesException(String message) {
		super(message);
	}
	
	public AppPropertiesException(Throwable cause) {
		super(cause);
	}
	
	public AppPropertiesException(String message, Throwable cause) {
		super(message, cause);
	}
}
