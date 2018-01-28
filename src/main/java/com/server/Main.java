package com.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.models.entities.Adress;
import com.models.entities.Friendship;
import com.models.entities.User;
import com.models.entities.UserDetalis;

public class Main {
	
	
	public static void main (String args[]) {
		AsynchronousServerSocketChannel server;
		
		try {
			SessionFactory factory = new Configuration().configure().addAnnotatedClass(User.class)
					.addAnnotatedClass(Adress.class).addAnnotatedClass(Friendship.class)
					.addAnnotatedClass(UserDetalis.class).buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
