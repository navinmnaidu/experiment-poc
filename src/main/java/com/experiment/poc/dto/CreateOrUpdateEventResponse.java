package com.experiment.poc.dto;

/**
 * Create or update event response.
 * @author Navin Naidu
 */

public class CreateOrUpdateEventResponse {

	/**
	 * event ID
	 */
	private String id;

	/**
	 * public constructor.
	 * @param id event ID
	 */
	public CreateOrUpdateEventResponse(String id) {
		this.id = id;
	}

	/**
	 * Getter for <code>id</code>
	 * @return event Id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter for <code>id</code>
	 * @param id event Id.
	 */
	public void setId(String id) {
		this.id = id;
	}

}