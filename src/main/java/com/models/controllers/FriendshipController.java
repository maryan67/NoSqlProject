package com.models.controllers;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.models.CRUDEntity;
import com.models.entities.Friendship;

class FriendshipController implements CRUDEntity {

	private Session session;

	protected FriendshipController(Session session) {
		super();
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
			session.flush();
			session.close();
		}
	}




	public void findById(Object o) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Friendship friendship = (Friendship) session.load(Friendship.class, new Integer(id));

			session.delete(friendship);
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



}
