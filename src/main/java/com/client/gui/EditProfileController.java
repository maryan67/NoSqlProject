package com.client.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EditProfileController {

	@FXML
	private Button btnConfirm;
	
	@FXML
	private Button btnCancel;
	
	public void onCancelClick(ActionEvent event) throws IOException {
		EditProfileFunctions.backToLogin(event);
	}
}
