package com.experiment.poc.exception;

/**
 * Base exception
 * @author Navin Naidu
 */
public class BaseException extends Exception {

	private static final long serialVersionUID = -6448751982718645085L;

	/**
	 * public constructor
	 * @param errorMessage error message
	 */
	public BaseException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * public constructor
	 * @param th Throwable
	 */
	public BaseException(Throwable th) {
		super(th);
	}

	/**
	 * public constructor
	 * @param errorMessage error message
	 * @param th Throwable
	 */
	public BaseException(String errorMessage, Throwable th) {
		super(errorMessage, th);
	}
}