package com.models.controllers;

import org.hibernate.Session;

import com.models.CRUDEntity;

public class ControllerFactory {
	
	

	public ControllerFactory() {}
	
	public CRUDEntity getController(String entity, Session session)
	{
		
		if(entity.equals("User")) {
			return new UserController(session);
		}
		if(entity.equals("Friendship")) {
			return new FriendshipController(session);
		}
		if(entity.equals("UserDetails")) {
			return new UserDetalisController(session);
		}
		if(entity.equals("Adress")) {
			return new AdressController(session);
		}
		return null;
		
	}

}
