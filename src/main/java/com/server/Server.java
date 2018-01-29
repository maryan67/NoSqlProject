package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.models.communication.Request;
import com.models.communication.Response;
import com.models.communication.ResponseType;
import com.models.entities.Adress;
import com.models.entities.Friendship;
import com.models.entities.User;
import com.models.entities.UserDetalis;


public class Server extends Thread {

	static List <ServerHandler> clients = new ArrayList<ServerHandler>();
	public void run() {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(User.class)
				.addAnnotatedClass(Adress.class).addAnnotatedClass(Friendship.class)
				.addAnnotatedClass(UserDetalis.class).buildSessionFactory();

		try {
			ServerSocket server = new ServerSocket(6666);
			while (!server.isClosed()) {
				Socket connection = server.accept();
				System.out.println("Client connected");
				ObjectOutputStream oOut = new ObjectOutputStream(connection.getOutputStream());
				ObjectInputStream oIn = new ObjectInputStream(connection.getInputStream());
				System.out.println("ajung aci");
				ServerHandler start = new ServerHandler(connection,factory,oIn,oOut);
				start.start();
				clients.add(start);
			}
		} catch (SocketException e) {
			System.out.println("Server closed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
class ServerHandler extends Thread {

private User loggedUser = new User();
private Socket socket;
private SessionFactory factory;
private ObjectInputStream oIn;
private ObjectOutputStream oOut;




public ServerHandler(Socket socket, SessionFactory factory, ObjectInputStream oIn,
		ObjectOutputStream oOut) {

	this.socket = socket;
	this.factory = factory;
	this.oIn = oIn;
	this.oOut = oOut;
}


public User getLoggedUser() {
	return loggedUser;
}


public void setLoggedUser(User loggedUser) {
	this.loggedUser = loggedUser;
}


public ObjectOutputStream getoOut() {
	return oOut;
}



@Override
public void run() {
	
	try {
		
		System.out.println("Client handler started");
		Request request;
		Response response = null;
		while(1 == 1) {
			request = (Request) oIn.readObject();
			
			
			response = request.createResponse(factory.openSession());
			
			
			if(response.getResponseType().equals( ResponseType.RESPONSE_LOGIN_OK)) {
				if(response.isSuccess()) {
					loggedUser = request.getFrom();
					
				for(ServerHandler client : Server.clients) {
					response.getOnlineUsers().add(client.getLoggedUser());
				}}
				
			}
			if(response.getResponseType() == ResponseType.RESPONSE_REFRESHONLINE) {
				for(ServerHandler client : Server.clients) {
					response.getOnlineUsers().add(client.getLoggedUser());
				}
			}
			if(request.isMessage())
			{
				for(ServerHandler client : Server.clients) {
					
					if(client.getLoggedUser().equals(request.getTo())) {
					client.getoOut().writeObject(response);
				
					break;
					}
				}
				continue;
			}
			oOut.writeObject(response);
			
		}
		
	} catch (IOException e ) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	
	
}





}
