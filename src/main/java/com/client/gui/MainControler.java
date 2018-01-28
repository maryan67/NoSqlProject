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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainControler {

	@FXML
	private Button btnChat;
	
	@FXML
	private Button btnEdit;
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private PasswordField txtPassword;
	
	@FXML
	private Label lblUserWarning;
	
	@FXML
	private Label lblPassWarning;
	
	private User user;
	
	@FXML
	public void goToRegister (ActionEvent event) throws IOException {
		LoginFunctions.goToRegister(event);

	}
	
	public void onEditClick(ActionEvent event) throws IOException {
		LoginFunctions.goToEdit(event);
	}
	
	public void onChatClick(ActionEvent event) throws IOException {
		LoginFunctions.goToChat(event);
	}
	
	@FXML
	public void login (ActionEvent event) throws IOException {
		System.out.println("Click event");
		warnings();
		if (LoginFunctions.checkData(txtUsername.getText(), txtPassword.getText())) {
			user = LoginFunctions.createUser(txtUsername.getText(), txtPassword.getText());
			System.out.println("User object created");
			System.out.println(user);
			btnChat.setDisable(false);
			btnEdit.setDisable(false);
		}
		
	}
	
	
	
	@FXML 
	public void warnings() {
		if (txtUsername.getText() != null && !txtUsername.getText().isEmpty()) {
			lblUserWarning.setVisible(false);
		}
		else {
			lblUserWarning.setText("Username field cannot be empty.");
			lblUserWarning.setVisible(true);
		}
		
		
		if (txtPassword.getText() != null && !txtPassword.getText().isEmpty()) {
			lblPassWarning.setVisible(false);
		}
		else {
			lblPassWarning.setText("Password field cannot be empty.");
			lblPassWarning.setVisible(true);
		}
	}
	
}
