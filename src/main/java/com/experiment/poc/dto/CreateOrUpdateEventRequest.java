package com.experiment.poc.dto;

/**
 * Create or update event request.
 * @author Navin Naidu
 */

public class CreateOrUpdateEventRequest {

	/**
	 * event name.
	 */
	private String name;

	/**
	 * event description.
	 */
	private String description;

	/**
	 * event location.
	 */
	private String location;

	/**
	 * event time.
	 */
	private long time;

	/**
	 * Getter for <code>name</code>
	 * @return event name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for <code>name</code>
	 * @param name event name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for <code>description</code>
	 * @return event description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter for <code>description</code>
	 * @param description event description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter for <code>location</code>
	 * @return event location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Setter for <code>location</code>
	 * @param location event location.
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Getter for <code>time</code>
	 * @return event time.
	 */
	public long getTime() {
		return time;
	}

	/**
	 * Setter for <code>time</code>
	 * @param time event time.
	 */
	public void setTime(long time) {
		this.time = time;
	}

}