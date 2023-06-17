package com.bs.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bs.hibernate.model.Customer;
import com.bs.util.HibernateUtil;

public class CustomerDAO {
	public List<Customer> getAllCustomer() {
		List<Customer> list = new ArrayList<>();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Customer");
			list =(List<Customer>) query.list();
		} catch (HibernateException e) {
			System.out.println(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}
}
