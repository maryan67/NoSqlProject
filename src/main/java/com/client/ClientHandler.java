package com.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.models.communication.Request;
import com.models.communication.RequestType;
import com.models.communication.Response;
import com.models.entities.User;

public class ClientHandler {

     
	private ObjectInputStream dis;
	private ObjectOutputStream dos;
	
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
	
	
	
	
	
}
