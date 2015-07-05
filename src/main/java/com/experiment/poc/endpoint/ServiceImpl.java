package com.experiment.poc.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.experiment.poc.dto.BaseResponse.STATUS;
import com.experiment.poc.dto.GetWelcomeMessageResponse;
import com.experiment.poc.dto.LoginRequest;
import com.experiment.poc.dto.LoginResponse;
import com.experiment.poc.dto.LogonMessage;
import com.experiment.poc.exception.BaseException;
import com.experiment.poc.utils.CommonUtils;

/**
 * Implementation of Service
 * @author Navin Naidu
 */
public class ServiceImpl implements Service {

	private static final Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);

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
        res.setStatus(STATUS.OK);
        LogonMessage msg = new LogonMessage();
        msg.setResponse("Login successful for user " + request.getUsername());
        res.setData(msg);
        return res;
    }

/*	public String login(String email, String password) throws BaseException {
		if (email == null || "".equals(email) || password == null || "".equals(password)) {
			throw new BaseException("Empty or null email/password");
		}

		return "Welcome" + email;
	}*/

}
