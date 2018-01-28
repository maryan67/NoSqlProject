package com.client.gui;

import com.client.gui.RegisterFunctions;

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
	
	@FXML
	public void goBackToLogin (ActionEvent event) throws IOException {
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));/* Exception */
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	
	@FXML 
	public void getUserData (ActionEvent event) {
	
		boolean userOk = false;
		warnings();
		
		if (RegisterFunctions.checkData(txtUsername.getText(), txtPass1.getText(), txtPass2.getText())) {
			System.out.println("Registration Succesful");
			userOk = true;
		}
		else {
			System.out.println("Fields incorect");
			userOk = false;
		}
		
		if (userOk) {
			user = RegisterFunctions.createUser(txtUsername.getText(), txtPass1.getText());
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
