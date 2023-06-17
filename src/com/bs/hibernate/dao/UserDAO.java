package com.bs.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bs.util.HibernateUtil;

public class UserDAO {
	public String login(String username, String password) {
		String role = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("select role from User where userName=:name and userPass=:pass");
			query.setParameter("name", username);
			query.setParameter("pass", password);
			role = (String) query.uniqueResult();
		} catch (HibernateException e) {
			System.out.println(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return role;

	}
}
