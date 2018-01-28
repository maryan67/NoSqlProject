package com.client.gui;

import java.io.IOException;

import com.models.entities.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainControler {

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
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Register.fxml"));/* Exception */
		Scene scene = new Scene(root);
		stage.setTitle("Registration");
		stage.setScene(scene);
		stage.show();

	}
	
	@FXML
	public void login (ActionEvent event) {
		System.out.println("Click event");
		warnings();
		if (LoginFunctions.checkData(txtUsername.getText(), txtPassword.getText())) {
			user = LoginFunctions.createUser(txtUsername.getText(), txtPassword.getText());
			System.out.println("User object created");
			System.out.println(user);
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
