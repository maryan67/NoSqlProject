package com.models.communication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.models.entities.User;

public class Response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResponseType responseType;
	private boolean success;
	private String message;
	private User from;
	private User loggedUser;
	
	
	
	public User getLoggedUser() {
		return loggedUser;
	}
	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}
	private List<User> onlineUsers = new ArrayList<User>();
	public Response(ResponseType responseType) {
		this.responseType = responseType;
		success= false;
		message = "";
	}
	public List<User> getOnlineUsers() {
		return onlineUsers;
	}
	public void setOnlineUsers(List<User> onlineUsers) {
		this.onlineUsers = onlineUsers;
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
	public User getFrom() {
		return from;
	}
	public void setFrom(User from) {
		this.from = from;
	}
	
	
	    // NA MA
	//cepl
	
	
}
