package com.experiment.poc.authentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Authentication Manager implementation
 * @author Navin Naidu
 * @version $Id: $
 */

public class ServiceAuthenticationManager implements AuthenticationManager<AuthNToken> {

	private static final String FILE_PATH = "authNToken.txt";
	private static final String UTF_8 = "UTF-8";
	private Map<String, String> authMapping;

	/**
	 * public constructor 
	 */
	public ServiceAuthenticationManager() {
		authMapping = loadAuthNToken();
	}

	/**
	 * load authentication token
	 * @return set of authentication token
	 */
	public Map<String,String> loadAuthNToken() {
		Map<String, String> authMapping = new HashMap<String, String>();
		InputStream inputStream = 
			Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_PATH);
		if (inputStream != null) {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, UTF_8));
				String token;
				while((token = reader.readLine()) != null) {
				    String [] mapping = token.split("=");
				    authMapping.put(mapping[0], mapping[1]);
				}
			}
			catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("Authentication token loaded.");
		}
		else {
			System.out.println(FILE_PATH + ": not found");
		}
		return authMapping;
	}

	public AuthNToken authenticate(AuthNToken authNToken) {
		boolean authenticated = authMapping.containsValue(authNToken.getAuthNToken());
		authNToken.setAuthenticated(authenticated);
		return authNToken;
	}
	
	public String getAuthToken(String email) {
	    return authMapping.get(email);
	}

}