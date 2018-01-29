package com.models.controllers;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
			User user = session.load(User.class, new Integer(id));
			
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
	
	public boolean checkLogin(User user, User loggedUser) {
		User toCheck = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String queryString = "from User where user_name = :user_name";
            Query<?> query = session.createQuery(queryString);
            query.setParameter("user_name", user.getUserName());
            toCheck = (User) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
       
    
		if(toCheck == null)
			return false;
		
		boolean result =toCheck.getPassWord().equals(user.getPassWord());
		if(result) {
			loggedUser.setDetailsId(toCheck.getDetailsId());
			loggedUser.setID(toCheck.getID());
			loggedUser.setPassWord(toCheck.getPassWord());
			loggedUser.setUserName(toCheck.getUserName());
		}
		return result;
	}

}
