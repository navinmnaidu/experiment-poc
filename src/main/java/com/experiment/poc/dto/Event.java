package com.experiment.poc.dto;

/**
 * Event DTO
 * @author Navin Naidu
 */

public class Event {

	private String id;
	private String name;
	private String description;
	private String location;
	private long time;

	/**
	 * Getter for <code>id</code>
	 * @return event Id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter for <code>id</code>
	 * @param id event id.
	 */
	public void setId(String id) {
		this.id = id;
	}

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
	 * Getter for <code>location</code>
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
	 * Getter for <code>time</code>
	 * @param time event time.
	 */
	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Event [");
		sb.append("name=").append(name);
		sb.append(",description=").append(description);
		sb.append(",location=").append(location);
		sb.append("time=").append(time);
		sb.append("]");
		return sb.toString();
	}
}