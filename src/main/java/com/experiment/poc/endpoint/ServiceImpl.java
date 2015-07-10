package com.experiment.poc.endpoint;

import com.experiment.poc.authentication.ServiceAuthenticationManager;
import com.experiment.poc.dto.BaseResponse.STATUS;
import com.experiment.poc.dto.GetWelcomeMessageResponse;
import com.experiment.poc.dto.LoginRequest;
import com.experiment.poc.dto.LoginResponse;
import com.experiment.poc.dto.LogonMessage;
import com.experiment.poc.exception.BaseException;
import com.experiment.poc.utils.CommonUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation of Service
 * @author Navin Naidu
 */
public class ServiceImpl implements Service {

	private static final Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);
	
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

    public LoginResponse login(LoginRequest request) throws BaseException {
        LoginResponse res = new LoginResponse();
        LogonMessage msg = new LogonMessage();
        res.setData(msg);
        String authToken = serviceAuthenticationManager.getAuthToken(request.getUsername());
        if(authToken != null) {
            res.setStatus(STATUS.OK);
            msg.setAuthToken(authToken);
            msg.setResponse("Login successful for user " + request.getUsername());
            res.setData(msg);            
        } else {
            res.setStatus(STATUS.ERROR);
            msg.setResponse("Authentication failed for user " + request.getUsername());
        }
        return res;
    }

}
