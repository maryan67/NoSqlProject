package com.main;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.models.entities.*;
import com.client.gui.*;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	private static SessionFactory factory;
	private static final Logger logger = LogManager.getLogger(Main.class.getName());

	@Override
	public void start (Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
		Scene scene = new Scene (root);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {

		launch(args);
		
		try {
			factory = new Configuration().configure().addAnnotatedClass(User.class)
					.addAnnotatedClass(Adress.class).addAnnotatedClass(Friendship.class)
					.addAnnotatedClass(UserDetalis.class).buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	

}
