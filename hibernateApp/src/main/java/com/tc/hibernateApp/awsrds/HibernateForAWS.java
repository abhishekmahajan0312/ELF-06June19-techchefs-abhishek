package com.tc.hibernateApp.awsrds;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.extern.java.Log;

@Log
public class HibernateForAWS {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("com/tc/hibernateApp/awsrds/hibernate.aws.cfg.xml");
		configuration.addAnnotatedClass(NewEmployeeInfoBean.class);

		// 2. Build the SessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// 3.Open the session
		Session session = sessionFactory.openSession();

		// 4. Interact with the DB via Session
		NewEmployeeInfoBean bean = session.get(NewEmployeeInfoBean.class, 1);
		log.info("1st Time : " + bean.toString());

		// 5.Close the Session
		session.close();
	}
}
