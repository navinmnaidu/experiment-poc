package com.experiment.poc.endpoint;

import com.experiment.poc.exception.BaseException;
import com.experiment.poc.utils.CommonUtils;

public class ServiceImpl implements Service {

	public String getWelcomeMessage(String name) throws BaseException {
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
