package com.models.communication;

import java.io.Serializable;

public class Response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResponseType responseType;
	private boolean success;
	private String message;
	private User from;
	public Response(ResponseType responseType) {
		this.responseType = responseType;
		success= false;
		message = "";
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseType getResponseType() {
		return responseType;
	}
	
	
	
	
}
