package com.experiment.poc.endpoint;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.experiment.poc.dto.GetWelcomeMessageResponse;
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
	 * @param email email of the user
	 * @param password password of the user
	 * @return String welcome message
	 * @throws BaseException if any.
	 */
/*	@POST
	@Path("/login")
	@Consumes(APPLICATION_FORM_URLENCODED)
	String login(@FormParam("email") String email, @FormParam("password") String password) throws BaseException;
*/
}
