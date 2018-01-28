package com.client.gui;

import java.io.IOException;

import com.client.ClientHandler;
import com.models.entities.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatScreenController {

	@FXML
	private Button btnSend;
	
	@FXML
	private Button btnRefresh;
	
	@FXML
	private Label lblTextArea;
	
	@FXML
	private TextField txtInput;
	
	private User user;
	
	private FxmlFunctions functions = FxmlFunctions.getSingletonInstance();
	
	@FXML
	public void onSendClick() {
		lblTextArea.setText(lblTextArea.getText() + txtInput.getText() + "\n");
		txtInput.clear();
	}
	
	@FXML
	public void onBackClick(ActionEvent event) throws IOException {
		functions.backToLogin(event);
	}
	
	public void listen () {
		ClientHandler clientHandler = new ClientHandler (user);
		clientHandler.connect();
		
	}
	
	
	
		
}
