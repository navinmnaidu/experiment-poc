package com.experiment.poc.endpoint;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.experiment.poc.dto.BaseResponse;
import com.experiment.poc.dto.CreateOrUpdateEventRequest;
import com.experiment.poc.dto.CreateOrUpdateEventResponse;
import com.experiment.poc.dto.Event;
import com.experiment.poc.dto.GetEventsResponse;
import com.experiment.poc.dto.GetWelcomeMessageResponse;
import com.experiment.poc.dto.LoginRequest;
import com.experiment.poc.dto.LogonMessage;
import com.experiment.poc.exception.BaseException;

/**
 * Service interface
 * @author Navin Naidu
 */

@Path("/api")
@Consumes({APPLICATION_JSON})
@Produces({APPLICATION_JSON, TEXT_PLAIN})
public interface Service {

	/**
	 * Returns a welcome message
	 * @param name name of the user
	 * @return String welcome message
	 * @throws BaseException if any.
	 */
	@GET
	@Path("/welcome")
	GetWelcomeMessageResponse getWelcomeMessage(@QueryParam("name") String name) throws BaseException;

	/**
	 * Returns a welcome message
	 * @param request 
	 * @return {@link BaseResponse} base response {@link LogonMessage} object.
	 * @throws BaseException if any.
	 */
	@POST
	@Path("/login")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	BaseResponse<LogonMessage> login(LoginRequest request) throws BaseException;

	/**
	 * Returns a welcome message
	 * @param request 
	 * @return {@link BaseResponse} base response {@link GetEventsResponse} object.
	 * @throws BaseException if any.
	 */
	@GET
	@Path("/events")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	BaseResponse<GetEventsResponse> getEvents() throws BaseException;

	/**
	 * Create a new event.
	 * @param request {@link CreateOrUpdateEventRequest} request.
	 * @return {@link BaseResponse} base response of {@link CreateOrUpdateEventResponse} object.
	 * @throws BaseException if any.
	 */
	@PUT
	@Path("/events")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	BaseResponse<CreateOrUpdateEventResponse> createOrUpdateEvent(CreateOrUpdateEventRequest request) 
		throws BaseException;

	/**
	 * Get event details.
	 * @param id event id 
	 * @return {@link BaseResponse} base response of {@link Event} object.
	 * @throws BaseException if any.
	 */
	@GET
	@Path("/events/{eventId}")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	BaseResponse<Event> getEvent(@PathParam("eventId") String id) throws BaseException;

	/**
	 * Deletes an event.
	 * @param id event id 
	 * @return {@link BaseResponse} base response object.
	 * @throws BaseException if any.
	 */
	@DELETE
	@Path("/events/{eventId}")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	BaseResponse<String> deleteEvent(@PathParam("eventId") String id) throws BaseException;

}