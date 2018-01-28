package com.client.gui;

import com.models.entities.User;

import javafx.fxml.FXML;

public class RegisterFunctions {

	public static Boolean checkData (String username, String pass1, String pass2) {
		Boolean ok = true;
		
		ok = !username.isEmpty();
		ok = !pass1.isEmpty();
		if (!pass2.isEmpty())
			if (pass1.equals(pass2))
				ok = true;
			else
				ok = false;
		else
			ok = false;
		
		return ok;

	}
	
	public static User createUser (String username, String pass) {
		User user = new User();
		user.setUserName(username);
		user.setPassWord(pass);
		return user;
	}
	
	
}
