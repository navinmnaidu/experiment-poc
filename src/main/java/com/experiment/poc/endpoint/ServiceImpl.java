package com.experiment.poc.endpoint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.experiment.poc.authentication.ServiceAuthenticationManager;
import com.experiment.poc.dto.BaseResponse;
import com.experiment.poc.dto.BaseResponse.STATUS;
import com.experiment.poc.dto.CreateOrUpdateEventRequest;
import com.experiment.poc.dto.CreateOrUpdateEventResponse;
import com.experiment.poc.dto.Event;
import com.experiment.poc.dto.GetEventsResponse;
import com.experiment.poc.dto.GetWelcomeMessageResponse;
import com.experiment.poc.dto.LoginRequest;
import com.experiment.poc.dto.LogonMessage;
import com.experiment.poc.exception.BaseException;
import com.experiment.poc.utils.CommonUtils;

/**
 * Implementation of Service
 * @author Navin Naidu
 */
public class ServiceImpl implements Service {

	private static final Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);

	/**
	 * Map of Event Id and {@link Event} object.
	 */
	private Map<String, Event> eventMap;

	{
		eventMap = new HashMap<String, Event>();

		Event e1 = new Event();
		e1.setId(UUID.randomUUID().toString());
		e1.setName("trekking");
		e1.setDescription("Trekking at Mission Peak");
		e1.setLocation("Mission Peak @ Fremont");
		e1.setTime(System.currentTimeMillis() + 28*60*60*1000);

		Event e2 = new Event();
		e2.setId(UUID.randomUUID().toString());
		e2.setName("scoccer");
		e2.setDescription("Scoccer with Integral group");
		e2.setLocation("Mango park @ Sunnyvale");
		e2.setTime(System.currentTimeMillis() + 14*60*60*1000);

		Event e3 = new Event();
		e3.setId(UUID.randomUUID().toString());
		e3.setName("barbeque");
		e3.setDescription("Barbeque at Walmartlabs with VP");
		e3.setLocation("WalmartLabs @ Sunnyvale");
		e3.setTime(System.currentTimeMillis() + 6*24*60*60*1000);

		Event e4 = new Event();
		e4.setId(UUID.randomUUID().toString());
		e4.setName("movie");
		e4.setDescription("Bahubali with friends");
		e4.setLocation("Cinemax @ Cupertino");
		e4.setTime(System.currentTimeMillis() + 2*24*60*60*1000);

		eventMap.put(e1.getId(), e1);
		eventMap.put(e2.getId(), e2);
		eventMap.put(e3.getId(), e3);
		eventMap.put(e4.getId(), e4);
	}

	@Autowired
	private ServiceAuthenticationManager serviceAuthenticationManager;

	public GetWelcomeMessageResponse getWelcomeMessage(String name) throws BaseException {
		LOG.debug("welcomeAPI with parameter: {}", name);
		if (CommonUtils.isStringNullOrEmpty(name)) {
			throw new BaseException("Empty or null name");
		}
		String message = "Welcome onboard: " + name;
		GetWelcomeMessageResponse response = new GetWelcomeMessageResponse(message);
		return response;
	}

	public BaseResponse<LogonMessage> login(LoginRequest request) throws BaseException {
		BaseResponse<LogonMessage> response = new BaseResponse<LogonMessage>();
		LogonMessage msg = new LogonMessage();
		response.setData(msg);
		String authToken = serviceAuthenticationManager.getAuthToken(request.getUsername(), request.getPassword());
		if(authToken != null) {
			response.setStatus(STATUS.OK);
			msg.setAuthToken(authToken);
			msg.setResponse("Login successful for user " + request.getUsername());
			response.setData(msg);
		}
		else {
			response.setStatus(STATUS.ERROR);
			msg.setResponse("Authentication failed for user " + request.getUsername());
		}
		return response;
	}

	public BaseResponse<GetEventsResponse> getEvents()
		throws BaseException {
		BaseResponse<GetEventsResponse> response = new BaseResponse<GetEventsResponse>();

		Set<Event> events = new HashSet<Event>(eventMap.values());
		GetEventsResponse eventsResponse = new GetEventsResponse(events);

		response.setData(eventsResponse);
		response.setStatus(STATUS.OK);

		return response;
	}

	public BaseResponse<CreateOrUpdateEventResponse> createOrUpdateEvent(
		CreateOrUpdateEventRequest request) 
		throws BaseException {

		Event event = new Event();
		event.setId(UUID.randomUUID().toString());
		event.setName(request.getName());
		event.setLocation(request.getLocation());
		event.setDescription(request.getDescription());
		event.setTime(request.getTime());

		eventMap.put(event.getId(), event);

		CreateOrUpdateEventResponse createResponse = new CreateOrUpdateEventResponse(event.getId());
		BaseResponse<CreateOrUpdateEventResponse> response = 
			new BaseResponse<CreateOrUpdateEventResponse>();
		response.setData(createResponse);
		response.setStatus(STATUS.OK);
		return response;
	}

	public BaseResponse<String> deleteEvent(String id) throws BaseException {
		BaseResponse<String> response = new BaseResponse<String>();
		if (eventMap.containsKey(id)) {
			response.setStatus(STATUS.OK);
			eventMap.remove(id);
		}
		else {
			// send 202 response code.
			response.setStatus(STATUS.OK);
		}
		return response;
	}

	public BaseResponse<Event> getEvent(String id) throws BaseException {
		BaseResponse<Event> response = new BaseResponse<Event>();
		if (eventMap.containsKey(id)) {
			response.setStatus(STATUS.OK);
			response.setData(eventMap.get(id));
		}
		else {
			// send 202 response code.
			response.setStatus(STATUS.OK);
		}
		return response;
	}

}