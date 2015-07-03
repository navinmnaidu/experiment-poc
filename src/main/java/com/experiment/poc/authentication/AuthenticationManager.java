package com.experiment.poc.authentication;

/**
 * Authentication Manager
 * @author Navin Naidu
 * @param <T> type
 */
public interface AuthenticationManager<T> {

	/**
	 * Authenticate 
	 * @param authenticate authentication token
	 * @return 
	 */
	T authenticate(T authenticate);
}
