package com.models.controllers;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.models.CRUDEntity;
import com.models.entities.User;

public class UserController implements CRUDEntity {

	private Session session;

	public UserController(Session session) {
		this.session = session;
	}

	public void update(Object o) {

		

	}

	public void create(Object o) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(o);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}



	public void findById(Object o) {
		// TODO Auto-generated method stub

	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
