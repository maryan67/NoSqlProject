package com.client.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatScreenFunctions {

	public static void backToLogin (ActionEvent event) throws IOException {
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(RegisterFunctions.class.getResource("/fxml/Login.fxml"));/* Exception */
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
