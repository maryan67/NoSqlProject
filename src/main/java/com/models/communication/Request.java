package com.models.communication;

import com.models.CRUDEntity;
import com.models.controllers.ControllerFactory;
import com.models.controllers.UserController;
import com.models.entities.User;

public class Request {

	private RequestType requestType;

	private User from;
	private User to;
	public User getTo() {
		return to;
	}
	

	public void setTo(User to) {
		this.to = to;
	}


	Request(RequestType requestType) {
		this.requestType = requestType;
	}

	public Response createResponse() {

		ControllerFactory controllerFactory = new ControllerFactory();

		CRUDEntity controller = controllerFactory.getController("User", null);
		Response response = null;
		switch (requestType) {
		case REQUEST_ADDFRIEND:
			break;
		case REQUEST_CONFIRMFRIEND:
			break;
		case REQUEST_LOGIN: {
			((UserController) controller).checkLogin(from);

			break;
		}
		case REQUEST_REGISTER: {

			((UserController) controller).create(from);
			break;
		}
		case REQUEST_SENDMESSAGE:
			break;
		case REQUEST_VIEWUSER: {
			((UserController) controller).findById(from);
			break;
		}
		default:
			break;

		}
		
		return response;
	}

	public boolean isMessage() {
		return requestType.equals(RequestType.REQUEST_SENDMESSAGE);
	}
	

}
