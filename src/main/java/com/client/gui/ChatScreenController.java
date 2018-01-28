package com.client.gui;

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
	private Label lblTextArea;
	
	@FXML
	private TextField txtInput;
	
	
	@FXML
	public void onSendClick() {
		lblTextArea.setText(lblTextArea.getText() + txtInput.getText() + "\n");
		txtInput.clear();
	}
	
		
}
