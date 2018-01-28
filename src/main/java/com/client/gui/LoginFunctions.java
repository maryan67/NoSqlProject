package com.client.gui;

import java.io.IOException;

import com.models.entities.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
	
	public static void goToChat (ActionEvent event) throws IOException {
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(LoginFunctions.class.getResource("/fxml/ChatScreen.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Chat");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void goToRegister (ActionEvent event) throws IOException {
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(LoginFunctions.class.getResource("/fxml/Register.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Registration");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void goToEdit (ActionEvent event) throws IOException {
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(LoginFunctions.class.getResource("/fxml/EditProfile.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Edit Profile");
		stage.setScene(scene);
		stage.show();
	}
}
