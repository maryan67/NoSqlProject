package com.client.gui;

import com.models.entities.User;

public class LoginFunctions {
	
	public static Boolean checkData (String username, String pass) {
		Boolean ok = true;
		
		ok = !username.isEmpty();
		ok = !pass.isEmpty();
		
		return ok;

	}
	
	public static User createUser (String username, String pass) {
		User user = new User();
		user.setUserName(username);
		user.setPassWord(pass);
		return user;
	}
}
