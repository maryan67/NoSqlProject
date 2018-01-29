package com.client.gui;

import java.io.IOException;
import java.util.List;

import com.client.ClientHandler;
import com.models.entities.User;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlFunctions {

	
	private FxmlFunctions() {}
	
	private static FxmlFunctions singletonInstance = null;
	
	private User user;
	
	public ClientHandler clientHandler;
	
	
	//Screen switching
	public void backToLogin (ActionEvent event) throws IOException {
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(FxmlFunctions.class.getResource("/fxml/Login.fxml"));/* Exception */
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void goToChat (ActionEvent event) throws IOException {
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(FxmlFunctions.class.getResource("/fxml/ChatScreen.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Chat");
		stage.setScene(scene);
		stage.show();
	}
	
	public void goToRegister (ActionEvent event) throws IOException {
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(FxmlFunctions.class.getResource("/fxml/Register.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Registration");
		stage.setScene(scene);
		stage.show();
	}
	
	public void goToEdit (ActionEvent event) throws IOException {
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(FxmlFunctions.class.getResource("/fxml/EditProfile.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Edit Profile");
		stage.setScene(scene);
		stage.show();
	}
	
	//Login functions
	public Boolean checkLoginData (String username, String pass) {
		Boolean ok = true;
		
		ok = !username.isEmpty();
		ok = !pass.isEmpty();
		
		return ok;

	}
	
	public User createUser (String username, String pass) {
		User user = new User();
		user.setUserName(username);
		user.setPassWord(pass);
		return user;
	}
	
	public Boolean checkLogin (User user) {
		clientHandler = new ClientHandler (user);
		clientHandler.connect();
		return clientHandler.login();
	}
	
	//Register functions
	public Boolean checkRegisterData (String username, String pass1, String pass2) {
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
	
	public void registerUser (User user) {
		clientHandler = new ClientHandler (user);
		clientHandler.connect();
		if (clientHandler.register())
			System.out.println("Register succesful");
		else 
			System.out.println("Register failed");
	}
	
	//ChatScreen functions 
	public List <User> refreshLoggedUsers () {
		return FXCollections.observableArrayList(clientHandler.refreshOnlineUsers());
	}
	
	//singleton
	public static FxmlFunctions getSingletonInstance() {
		if(singletonInstance == null) {
			singletonInstance= new FxmlFunctions();
		}
		
		return singletonInstance;
	}
}
