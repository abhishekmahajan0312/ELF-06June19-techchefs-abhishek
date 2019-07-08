package com.tc.hibernateApp.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.extern.java.Log;

@Log
public class HibernateCacheTest2 {
	public static void main(String[] args) {
		log.info("1st time: " + getEmployeeData(1).toString());
		log.info("2nd time: " + getEmployeeData(1).toString());
		log.info("3rd time: " + getEmployeeData(1).toString());
	}// End Of Main

	private static NewEmployeeInfoBean getEmployeeData(int id) {
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
//				log.info("1st Time : " + bean.toString());

		// 5.Close the Session
		session.close();
		return bean;
	}// End of getEmployeeData(int)
}// End Of Class
