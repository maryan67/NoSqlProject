package com.client.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EditProfileController {

	@FXML
	private Button btnConfirm;
	
	@FXML
	private Button btnCancel;
	
	@FXML
	private Label lblWelcome;
	
	private FxmlFunctions functions = FxmlFunctions.getSingletonInstance();
	
	public void onCancelClick(ActionEvent event) throws IOException {
		functions.backToLogin(event);
	}
}
