package com.client.gui;


import java.io.IOException;

import com.models.entities.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
		
	private User user;

	@FXML
	private Button btnRegister;
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private TextField txtPass1;
	
	@FXML
	private TextField txtPass2;
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private Label lblUserWarning;
	
	@FXML
	private Label lblPass1Warning;
	
	@FXML
	private Label lblPass2Warning;
	
	@FXML
	private Label lblEmailWarning;
	
	private FxmlFunctions functions = FxmlFunctions.getSingletonInstance();
	
	@FXML
	public void goBackToLogin (ActionEvent event) throws IOException {
		functions.backToLogin(event);
	}
	
	@FXML 
	public void getUserData (ActionEvent event) {
	
		boolean userOk = false;
		warnings();
		
		if (functions.checkRegisterData(txtUsername.getText(), txtPass1.getText(), txtPass2.getText())) {
			userOk = true;
		}
		else {
			System.out.println("Fields incorect");
			userOk = false;
		}
		
		if (userOk) {
			user = functions.createUser(txtUsername.getText(), txtPass1.getText());
			functions.registerUser(user);
			btnRegister.setDisable(true);
		}
		
		
	}
	
	@FXML
	private void warnings () {

		
		if (txtUsername.getText() != null && !txtUsername.getText().isEmpty()) {
			lblUserWarning.setVisible(false);
		}
		else {
			lblUserWarning.setText("Username field cannot be empty.");
			lblUserWarning.setVisible(true);
		}
		
		
		if (txtPass1.getText() != null && !txtPass1.getText().isEmpty()) {
			lblPass1Warning.setVisible(false);
		}
		else {
			lblPass1Warning.setText("Password field cannot be empty.");
			lblPass1Warning.setVisible(true);
		}
		
		
		if (txtPass2.getText() != null && !txtPass2.getText().isEmpty()) {
			if (txtPass1.getText().equals(txtPass2.getText())) {
				lblPass1Warning.setVisible(false);
				lblPass2Warning.setVisible(false);
			}
			else {
				lblPass2Warning.setText("Passwords must match.");
				lblPass2Warning.setVisible(true);
			}
		}
		else {
			lblPass2Warning.setText("Password field cannot be empty.");
			lblPass2Warning.setVisible(true);
		}
		
		
		
	}
	
	
	
	
}
