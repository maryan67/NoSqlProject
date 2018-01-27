package com.main;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.models.*;
public class Main {

	private static SessionFactory factory;
	private static final Logger logger = LogManager.getLogger(Main.class.getName());

	public static void main(String[] args) {

		try {
			factory = new Configuration().configure().addAnnotatedClass(User.class)
					.addAnnotatedClass(Adress.class).addAnnotatedClass(Friendship.class)
					.addAnnotatedClass(UserDetalis.class).buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
