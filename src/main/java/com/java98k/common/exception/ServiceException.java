package com.java98k.common.exception;

public class ServiceException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2517144914762249429L;
	public ServiceException() {
		super();
	}
	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(Throwable cause) {
		super(cause);
	}
}
