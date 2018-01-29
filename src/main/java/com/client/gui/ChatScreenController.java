package com.client.gui;

import java.io.IOException;

import com.models.entities.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

	@FXML
	private ListView<User> listView;

	@FXML
	private Label lblChatPartner;
	
	@FXML
	private Label lblOnOff;

	@FXML
	private Label lblLoggedUser;
	
	private Boolean chatIsStarted= false;
	
	private User user;

	private User selectedUser;

	private FxmlFunctions functions;

	public ChatScreenController() {
		functions = FxmlFunctions.getSingletonInstance(this);
		System.out.println(functions.getLoggedUser());
		
	}
	@FXML
    public void initialize() {
		lblLoggedUser.setVisible(true);
		lblLoggedUser.setText("Welcome " + functions.getLoggedUser());
    }

	@FXML
	public void onSendClick() {
		System.out.println(selectedUser);
		functions.sendMessage(txtInput.getText(), selectedUser);
		lblTextArea.setText(lblTextArea.getText() + txtInput.getText() + "\n");
		txtInput.clear();

	}

	@FXML
	public void onBackClick(ActionEvent event) throws IOException {
		functions.backToLogin(event);
	}

	public void refreshUsers() {

		if (chatIsStarted == false) {
		ObservableList<User> userList = FXCollections.observableArrayList(functions.refreshLoggedUsers());
		System.out.println("Online users: " + userList);

		listView.setItems(userList);
		}
		else 
			System.out.println("Chat is on");

	}

	@FXML
	public void onChatClicked(ActionEvent event) {
		System.out.println("clicked on " + listView.getSelectionModel().getSelectedItem());
		lblChatPartner.setVisible(true);
		lblChatPartner.setText("Chatting with " + listView.getSelectionModel().getSelectedItem());
		selectedUser = listView.getSelectionModel().getSelectedItem();
		functions.listenToMessages(lblTextArea);
	}

	public void updateLabel(String text) {
		lblTextArea.setText(lblTextArea.getText() + text + "\n");
	}
	
	public void onSaveClicked(ActionEvent event) {
		// TODO stuff here
	}
	
	public void onStartClicked (ActionEvent event) {
		chatIsStarted = true;
		lblOnOff.setText("ON");
	}
	
	public void onStopClicked (ActionEvent event) {
		chatIsStarted = false;
		lblOnOff.setText("OFF");
	}

}
