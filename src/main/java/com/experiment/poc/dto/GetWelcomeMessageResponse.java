package com.experiment.poc.dto;

/**
 * Response class for GetWelcomeMessage
 * @author Navin Naidu
 */
public class GetWelcomeMessageResponse {

	private String message;

	/**
	 * public constructor
	 * @param message welcome message
	 */
	public GetWelcomeMessageResponse(String message) {
		this.message = message;
	}

	/**
	 * <p>Getter for the field <code>message</code>.</p>
	 * @return the welcome message
	 */
	public String getMessage() {
		return this.message;
	}
}