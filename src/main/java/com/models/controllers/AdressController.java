package com.models.controllers;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.models.CRUDEntity;
import com.models.entities.Adress;

public class AdressController implements CRUDEntity {

	private Session session;

	protected AdressController(Session session) {
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
			Adress adress = (Adress) session.load(Adress.class, new Integer(id));

			session.delete(adress);
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
