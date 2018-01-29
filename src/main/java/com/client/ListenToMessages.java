package com.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

import com.client.gui.ChatScreenController;
import com.models.communication.Response;
import com.models.entities.User;

import javafx.application.Platform;

public class ListenToMessages extends Thread {

	private ObjectInputStream dis;
	private ChatScreenController chatScreenController;

	public ListenToMessages(ObjectInputStream dis, ChatScreenController chatScreenController) {
		this.dis = dis;
		this.chatScreenController = chatScreenController;
	}

	@Override
	public void run() {

		Response response = null;
		while (true) {
			try {
				response = (Response) dis.readObject();

				final User from = response.getFrom();
				final String message = response.getMessage();
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						chatScreenController.updateLabel(from + ":" + message);

					}

				});

			} catch (IOException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
