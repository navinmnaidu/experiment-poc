package com.experiment.poc.dto;

import java.util.Set;

/**
 * Get events response.
 * @author Navin Naidu
 */

public class GetEventsResponse {

	/**
	 * {@link Set} of {@link Event} objects. 
	 */
	private Set<Event> events;

	/**
	 * public constructor.
	 * @param events {@link Set} of {@link Event} object.
	 */
	public GetEventsResponse(Set<Event> events) {
		this.events = events;
	}

	/**
	 * Getter for <code>events</code>
	 * @return {@link Set} of {@link Event} objects.
	 */
	public Set<Event> getEvents() {
		return events;
	}

	/**
	 * Setter for <code>events</code>
	 * @param events {@link Set} of {@link Event} objects.
	 */
	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "GetEventsResponse [events=" + events + "]";
	}

}