package com.experiment.poc.authentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

/**
 * Authentication Manager implementation
 * @author Navin Naidu
 * @version $Id: $
 */

public class ServiceAuthenticationManager implements AuthenticationManager<AuthNToken> {

	private static final String FILE_PATH = "authNToken.txt";
	private static final String UTF_8 = "UTF-8";
	private Set<String> authNTokenSet;

	/**
	 * public constructor 
	 */
	public ServiceAuthenticationManager() {
		authNTokenSet = loadAuthNToken();
	}

	/**
	 * load authentication token
	 * @return set of authentication token
	 */
	public Set<String> loadAuthNToken() {
		Set<String> authNTokenSet = new HashSet<String>();
		InputStream inputStream = 
			Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_PATH);
		if (inputStream != null) {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, UTF_8));
				String token;
				while((token = reader.readLine()) != null) {
					authNTokenSet.add(token);
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
		return authNTokenSet;
	}

	public AuthNToken authenticate(AuthNToken authNToken) {
		boolean authenticated = authNTokenSet.contains(authNToken.getAuthNToken());
		authNToken.setAuthenticated(authenticated);
		return authNToken;
	}

}