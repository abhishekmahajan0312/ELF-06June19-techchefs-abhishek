package com.tc.hibernateApp.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tc.hibernate.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class InsertDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		// HQL query to delete the record with where clause and dynamic value
		String hql = "insert into EmployeeNewInfoBean(eid,name,email) select id,name,email from EmployeeInfoBean where id=102";
		// Create Query Object. Query is an interface in hibernate package.
		// createQuery is used for creating the hql query.
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			int result = query.executeUpdate();
			log.info("result:" + result);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
