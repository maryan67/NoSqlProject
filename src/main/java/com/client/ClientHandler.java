package com.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import com.models.communication.Request;
import com.models.communication.RequestType;
import com.models.communication.Response;
import com.models.entities.User;

import javafx.scene.control.Label;

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

		 Thread sendMessage = new Thread(new Runnable() 
	        {
	            @Override
	            public void run() {
	               
	 
	                     
	                    try {
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
	public void startListeningToMessages(final Label lblTextArea) {
		  Thread readMessage = new Thread(new Runnable() 
	        {
	            @Override
	            public void run() {
	 
	            	Response response = null;
	                while (true) {
	                    try {
	                    	response = (Response) dis.readObject();
	                    	lblTextArea.setText(lblTextArea.getText()+response.getFrom().getUserName()+":"+response.getMessage()+"\n");
	                        
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
	
	
	
	
}
