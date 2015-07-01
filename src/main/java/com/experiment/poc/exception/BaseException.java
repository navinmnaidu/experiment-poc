package com.experiment.poc.exception;

public class BaseException extends Exception {

	private static final long serialVersionUID = -6448751982718645085L;
	
	private int httpStatusCode;
	
	public BaseException(String errorMessage) {
		super(errorMessage);
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public int getHttpStatusCode() {
		return this.httpStatusCode;
	}

	
}
