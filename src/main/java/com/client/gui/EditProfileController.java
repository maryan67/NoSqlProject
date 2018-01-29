package com.client.gui;

import java.io.IOException;

import com.models.entities.Adress;
import com.models.entities.UserDetalis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditProfileController {

	@FXML
	private Button btnConfirm;
	
	@FXML
	private Button btnCancel;
	
	@FXML
	private Label lblWelcome;
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private TextField txtStr;
	
	@FXML
	private TextField txtStrNr;
	
	@FXML
	private TextField txtBlckNr;
	
	@FXML
	private TextField txtZip;
	
	@FXML
	private TextField txtBio;
	
	private UserDetalis details;
	
	private Adress adress;
	
	private FxmlFunctions functions = FxmlFunctions.getSingletonInstance(null);
	
	public void onCancelClick(ActionEvent event) throws IOException {
		functions.backToLogin(event);
	}
	
	
	public void onConfirmClicked(ActionEvent event) {
		details.setBio(txtBio.getText());
		details.seteMail(txtEmail.getText());
		
		adress.setStreet(txtStr.getText());
		adress.setStreetNumber(Integer.parseInt(txtStrNr.getText()));
		adress.setBlockNumber(Integer.parseInt(txtBlckNr.getText()));
		adress.setZipCode(txtZip.getText());
	}
}
