package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.models.entities.Adress;
import com.models.entities.Friendship;
import com.models.entities.User;
import com.models.entities.UserDetalis;

public class Server extends Thread {

	private static HashSet<ServerHandler> clients;
	public void run() {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(User.class)
				.addAnnotatedClass(Adress.class).addAnnotatedClass(Friendship.class)
				.addAnnotatedClass(UserDetalis.class).buildSessionFactory();

		try {
			ServerSocket server = new ServerSocket(6666);
			while (!server.isClosed()) {
				Socket connection = server.accept();
				ServerHandler start = new ServerHandler(connection, factory);
				clients.add(start);
				start.start();
			}
		} catch (SocketException e) {
			System.out.println("Server closed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
class ServerHandler extends Thread {

private User loggedUser;
private Socket socket;
private SessionFactory factory;

public ServerHandler(Socket socket, SessionFactory factory) {
	this.socket = socket;
	this.factory = factory;
}


public void run() {
	
	try {
		ObjectInputStream oIn = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream oOut = new ObjectOutputStream(socket.getOutputStream());
		
		while(1 == 1) {
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//usr = (User) oIn.readObject();
	//ObjectOutputStream oOut = new ObjectOutputStream(socket.getOutputStream());
	
	
	
}





}
