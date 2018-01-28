package com.client.gui;

import java.io.IOException;

import com.client.ClientHandler;
import com.models.entities.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
	
	public static void registerUser (User user) {
		ClientHandler clientHandler = new ClientHandler (user);
		clientHandler.connect();
		if (clientHandler.register())
			System.out.println("Register succesful");
		else 
			System.out.println("Register failed");
	}
	
	public static void backToLogin (ActionEvent event) throws IOException {
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(RegisterFunctions.class.getResource("/fxml/Login.fxml"));/* Exception */
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
}
