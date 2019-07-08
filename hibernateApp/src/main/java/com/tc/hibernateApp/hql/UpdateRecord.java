package com.tc.hibernateApp.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tc.hibernate.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class UpdateRecord {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		// HQL query to update the record with where clause
		String hql = "update from EmployeeInfoBean set name='Madhavi' where id=103";
		// Create Query Object. Query is an interface in hibernate package.
		// createQuery is used for creating the hql query.
		Query query = session.createQuery(hql);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			// With query object we can call 3 function based on the requirement
			// 1. list(): To get all the data from database. It is like select query without
			// condition in SQL.
			// 2. executeUpdate(): To update any data in Table. Like insert, update, delete
			// queries in SQL.
			// 3. uniqueResult(): To get the result based upon some condition from the
			// table. Like select query with
			// where clause in SQL.
			int num = query.executeUpdate();
			transaction.commit();
			log.info("No. of rows updated: " + num);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
