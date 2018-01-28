package com.models.controllers;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.models.CRUDEntity;
import com.models.entities.User;

public class UserController implements CRUDEntity {

	private Session session;

	protected UserController(Session session) {
		this.session = session;
	}

	public void update(Object o) {

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(o);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

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
		
		

	}

	public void delete(int id) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			User user = (User) session.load(User.class, new Integer(id));
			
			session.delete(user);
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
	
	public boolean checkLogin(User user) {
		return true;
	}

}
