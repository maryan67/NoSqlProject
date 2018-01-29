package com.client.gui;

import java.io.IOException;
import java.util.Iterator;

import com.client.ClientHandler;
import com.models.entities.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
	private ListView <User> listView;
	
	@FXML
	private Label lblChatPartner;
	
	private User user;
	
	private User selectedUser;
	
	private FxmlFunctions functions = FxmlFunctions.getSingletonInstance();
	
	
	
	@FXML
	public void onSendClick() {
		System.out.println(selectedUser);
		functions.sendMessage(txtInput.getText(), selectedUser);
		lblTextArea.setText(lblTextArea.getText() + txtInput.getText() + "\n");
		txtInput.clear();
		functions.listenToMessages(lblTextArea);
	}
	
	@FXML
	public void onBackClick(ActionEvent event) throws IOException {
		functions.backToLogin(event);
	}
	
	public void refreshUsers () {
		
		ObservableList<User> userList= FXCollections.observableArrayList(functions.refreshLoggedUsers());
		System.out.println("Online users: " + userList);
		
		listView.setItems(userList);
		
		
		
	}
	
	@FXML
	public void onChatClicked(ActionEvent event) {
		System.out.println("clicked on " + listView.getSelectionModel().getSelectedItem());
		lblChatPartner.setVisible(true);
		lblChatPartner.setText("Chatting with " + listView.getSelectionModel().getSelectedItem());
		selectedUser= listView.getSelectionModel().getSelectedItem();
	}
	
		
}
