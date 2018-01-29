package com.models.communication;

import java.io.Serializable;

import org.hibernate.Session;

import com.models.CRUDEntity;
import com.models.controllers.ControllerFactory;
import com.models.controllers.UserController;
import com.models.entities.Adress;
import com.models.entities.User;
import com.models.entities.UserDetalis;

public class Request implements Serializable {

	private static final long serialVersionUID = 1L;
	private RequestType requestType;
	private User from;
	private User to;
	private String message;
	private UserDetalis userDetails;
	private Adress adress;

	public Request(RequestType requestType) {
		this.requestType = requestType;
	}

	public Response createResponse(Session session) {

		ControllerFactory controllerFactory = new ControllerFactory();

		CRUDEntity controller = controllerFactory.getController("User", session);
		Response response = null;
		switch (requestType) {
		case REQUEST_ADDFRIEND:
			break;
		case REQUEST_CONFIRMFRIEND:
			break;
		case REQUEST_LOGIN: {
			response = new Response(ResponseType.RESPONSE_LOGIN_OK);
			User loggedUser = null;
			if (((UserController) controller).checkLogin(from, loggedUser)) {
				response.setSuccess(true);
				response.setLoggedUser(loggedUser);
			}
			break;
		}
		case REQUEST_REGISTER: {
			((UserController) controller).create(from);
			response = new Response(ResponseType.RESPONSE_REGISTER_OK);
			response.setSuccess(true);
			break;
		}
		case REQUEST_SENDMESSAGE:
			response = new Response(ResponseType.RESPONSE_MESSAGE_DELIVERED);
			response.setMessage(message);
			response.setFrom(from);
			break;

		case REQUEST_REFRESHONLINE: {
			response = new Response(ResponseType.RESPONSE_REFRESHONLINE);

		}
		case REQUEST_ADDDETAILS: {
			controller = controllerFactory.getController("UserDetails", session);
			controller.create(userDetails);
			controller = controllerFactory.getController("Adress", session);
			controller.create(adress);
			response = new Response(ResponseType.RESPONSE_ADDDETAILS);
		}
		default:
			break;
		}

		return response;
	}

	public boolean isMessage() {
		return requestType.equals(RequestType.REQUEST_SENDMESSAGE);
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

	public Adress getAdress() {
		return adress;
	}

	public UserDetalis getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetalis userDetails) {
		this.userDetails = userDetails;
	}
	
}
