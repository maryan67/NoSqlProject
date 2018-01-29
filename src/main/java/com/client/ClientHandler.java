package com.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import com.client.gui.ChatScreenController;
import com.models.communication.Request;
import com.models.communication.RequestType;
import com.models.communication.Response;
import com.models.entities.Adress;
import com.models.entities.User;
import com.models.entities.UserDetalis;

import javafx.application.Platform;

public class ClientHandler {

	private ObjectInputStream dis;
	private ObjectOutputStream dos;

	private User loggedUser = new User();
	private User user;

	public ClientHandler(User user) {
		super();
		this.user = user;
	}

	public void connect() {
		Socket s;
		try {
			s = new Socket("localhost", 6666);
			dis = new ObjectInputStream(s.getInputStream());
			dos = new ObjectOutputStream(s.getOutputStream());

			Request request = new Request(RequestType.REQUEST_LOGIN);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean login() {
		Response response = null;
		Request request = new Request(RequestType.REQUEST_LOGIN);
		request.setFrom(user);
		try {
			dos.writeObject(request);
			response = (Response) dis.readObject();
			if(response.isSuccess())
			{
				loggedUser = response.getLoggedUser();
				System.out.println("Logged user is "+response.getLoggedUser());
				return true;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean register() {

		Response response = null;
		Request request = new Request(RequestType.REQUEST_REGISTER);
		request.setFrom(user);
		try {
			dos.writeObject(request);
			response = (Response) dis.readObject();
			return response.isSuccess();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<User> refreshOnlineUsers() {
		Response response = null;
		Request request = new Request(RequestType.REQUEST_REFRESHONLINE);
		try {
			dos.writeObject(request);
			response = (Response) dis.readObject();
			return response.getOnlineUsers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void sendMessage(final String message, final User recipient) {

		Thread sendMessage = new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					System.out.println(recipient);
					Request request = new Request(RequestType.REQUEST_SENDMESSAGE);
					request.setFrom(user);
					request.setTo(recipient);
					request.setMessage(message);
					dos.writeObject(request);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		sendMessage.start();

	}

	public void startListeningToMessages(final ChatScreenController chatScreenController) {
		Thread readMessage = new Thread(new Runnable() {
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
		});
		readMessage.start();
	}
	
	public User getLoggedUser() {
		return loggedUser;
	}
	public void createDetalisAndAdress(Adress adress, UserDetalis userDetails,User from) {
		Response response = null;
		Request request = new Request(RequestType.REQUEST_ADDDETAILS);
		try {
			request.setAdress(adress);
			request.setFrom(from);
			request.setUserDetails(userDetails);
			dos.writeObject(request);
			response = (Response) dis.readObject();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	

}
