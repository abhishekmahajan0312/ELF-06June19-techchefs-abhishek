package com.tc.hibernateApp.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.extern.java.Log;

@Log
public class HibernateCacheTest {
	public static void main(String[] args) {
		// 1. Load the config file
		Configuration configuration = new Configuration();
		configuration.configure("com/tc/hibernateApp/cache/hibernate.cache.cfg.xml");
		configuration.addAnnotatedClass(NewEmployeeInfoBean.class);

		// 2. Build the SessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// 3.Open the session
		Session session = sessionFactory.openSession();

		// 4. Interact with the DB via Session
		NewEmployeeInfoBean bean = session.get(NewEmployeeInfoBean.class, 1);
		log.info("1st Time : " + bean.toString());

		NewEmployeeInfoBean bean2 = session.get(NewEmployeeInfoBean.class, 1);
		log.info("2st Time : " + bean2.toString());

		NewEmployeeInfoBean bean3 = session.get(NewEmployeeInfoBean.class, 1);
		log.info("3st Time : " + bean3.toString());

		// 5.Close the Session
		session.close();
	}// End Of Main
}// End Of Class
