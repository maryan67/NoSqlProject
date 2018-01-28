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

import com.models.communication.Request;
import com.models.communication.Response;
import com.models.entities.Adress;
import com.models.entities.Friendship;
import com.models.entities.User;
import com.models.entities.UserDetalis;


public class Server extends Thread {

	static HashSet<ServerHandler> clients;
	public void run() {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(User.class)
				.addAnnotatedClass(Adress.class).addAnnotatedClass(Friendship.class)
				.addAnnotatedClass(UserDetalis.class).buildSessionFactory();

		try {
			ServerSocket server = new ServerSocket(6666);
			while (!server.isClosed()) {
				Socket connection = server.accept();
				ObjectInputStream oIn = new ObjectInputStream(connection.getInputStream());
				ObjectOutputStream oOut = new ObjectOutputStream(connection.getOutputStream());
				ServerHandler start = new ServerHandler(connection,factory,oIn,oOut);
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
private ObjectInputStream oIn;
private ObjectOutputStream oOut;




public ServerHandler(Socket socket, SessionFactory factory, ObjectInputStream oIn,
		ObjectOutputStream oOut) {

	this.socket = socket;
	this.factory = factory;
	this.oIn = oIn;
	this.oOut = oOut;
}


public ObjectOutputStream getoOut() {
	return oOut;
}




public void run() {
	
	try {
		
		
		Request request;
		Response response = null;
		while(1 == 1) {
			request = (Request) oIn.readObject();
			response = request.createResponse();
			if(request.isMessage())
			{
				for(ServerHandler client : Server.clients) {
					
					if(client.equals(request.getTo())) {
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
