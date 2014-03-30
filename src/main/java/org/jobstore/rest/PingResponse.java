package org.jobstore.rest;

public class PingResponse {

	private String message;
	
	public PingResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
