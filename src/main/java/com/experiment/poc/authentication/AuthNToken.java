package com.experiment.poc.authentication;

/**
 * Authentication Token
 * @author Navin Naidu
 */
public class AuthNToken {

	private String authNToken;

	private boolean authenticated;

	/**
	 * public constructor
	 * @param authNToken authentication token
	 */
	public AuthNToken(final String authNToken) {
		this.authNToken = authNToken;
	}

	/**
	 * <p>Getter for the field <code>authNToken</code>.</p>
	 * @return the authentication token
	 */
	public String getAuthNToken() {
		return this.authNToken;
	}

	/**
	 * <p>Setter for the field <code>authenticated</code>.</p>
	 * @param authenticated authentication status
	 */
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	/**
	 * If authenticated
	 * @return  <code>true</code> if authenticated;
	 *			<code>false</code> otherwise.
	 */
	public boolean isAuthenticated() {
		return this.authenticated;
	}
}