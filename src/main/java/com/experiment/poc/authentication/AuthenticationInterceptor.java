package com.experiment.poc.authentication;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

/**
 * Authentication interceptor used to authenticate APIs
 * @author Navin Naidu
 * @version $Id: $
 */
public class AuthenticationInterceptor extends AbstractPhaseInterceptor<Message> {

	AuthenticationManager<AuthNToken> authNManager;

	private static final String EMPTY_STRING = "";
	private static final String TOKEN = "TOKEN";
	private static final String REQUEST_URI = "org.apache.cxf.request.uri";

	private Set<String> unprotectedMethodURIs;

	private static final String LOGIN_ERROR_MSG = 
		"No authentication token available, login to get authentication token";
	private static final String AUTHENTICATION_ERROR_MSG = "Not authenticated, login to get authentication token";

	/**
	 * <p>Setter for the field <code>authNManager</code>.</p>
	 * @param authNManager authentication manager
	 */
	public void setAuthNManager(AuthenticationManager<AuthNToken> authNManager) {
		this.authNManager = authNManager;
	}

	public AuthenticationInterceptor() {
		super(Phase.UNMARSHAL);
		unprotectedMethodURIs = new HashSet<String>();
		unprotectedMethodURIs.add("/expirement-poc/api/login");
		unprotectedMethodURIs.add("/expirement-poc/api/register");
	}

	public void handleMessage(Message message) throws Fault {
		AuthNToken token = new AuthNToken(getAuthNToken(message));

		if (isUnprotectedAPI(message)) {
			return;
		}

		if (token.getAuthNToken() == null || EMPTY_STRING.equals(token.getAuthNToken().trim())) {
			throw new Fault(new SecurityException(LOGIN_ERROR_MSG));
		}

		authNManager.authenticate(token);

		if (!token.isAuthenticated()) {
			throw new Fault(new SecurityException(AUTHENTICATION_ERROR_MSG));
		}
	}

	/**
	 * Get authentication token from request header.
	 * @param message Input message
	 * @return authentication token from request header.
	 */
	@SuppressWarnings("unchecked")
	public String getAuthNToken(Message message) {
		String authNToken = null;
		try {
			Map<String, List<String>> protocolHeaders = 
				(Map<String, List<String>>) message.get(Message.PROTOCOL_HEADERS);
			if (protocolHeaders != null) {
				List<String> tokenHeader = protocolHeaders.get(TOKEN);
				if (tokenHeader != null) {
					authNToken = tokenHeader.get(0);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return authNToken;
	}

	/**
	 * Is requested URI unprotected
	 * @param message Input message
	 * @return  <code>true</code> if resource URI unprotected;
	 *			<code>false</code> otherwise.
	 */
	public boolean isUnprotectedAPI(Message message) {
		String requestURI = (String) message.get(REQUEST_URI);
		boolean unprotectedAPI = unprotectedMethodURIs.contains(requestURI);
		return unprotectedAPI;
	}
}