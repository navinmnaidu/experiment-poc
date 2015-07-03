package com.experiment.poc.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.experiment.poc.exception.BaseException;
import com.experiment.poc.utils.CommonUtils;

public class ServiceImpl implements Service {

	private static final Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);

	public String getWelcomeMessage(String name) throws BaseException {
		LOG.debug("welcomeAPI with parameter: {}", name);
		if (CommonUtils.isStringNullOrEmpty(name)) {
			throw new BaseException("Empty or null name");
		}
		return "Welcome onboard: " + name;
	}

/*	public String login(String email, String password) throws BaseException {
		if (email == null || "".equals(email) || password == null || "".equals(password)) {
			throw new BaseException("Empty or null email/password");
		}

		return "Welcome" + email;
	}*/

}
