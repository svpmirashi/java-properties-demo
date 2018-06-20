package com.wkfsfrc.fscframework.common;

/*
 * @Author: Shrikrishna Prabhumirashi
 * Date Created: 12-Jun-2018
 * */

public final class FsFrameworkException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FsFrameworkException() {
		super();
	}

	public FsFrameworkException(String message) {
		super(message);
	}
	
	public FsFrameworkException(Throwable cause) {
		super(cause);
	}
	
	public FsFrameworkException(String message, Throwable cause) {
		super(message, cause);
	}
}
