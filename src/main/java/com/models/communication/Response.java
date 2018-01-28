package com.models.communication;

public class Response {

	private ResponseType responseType;
	private boolean success;
	private String message;
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
