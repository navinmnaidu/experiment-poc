package com.experiment.poc.dto;

/**
 * 
 * @author Vikram Purohit
 *
 */
public class LogonMessage {
    private String response;
    
    private String authToken;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
    
    
}
