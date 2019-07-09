package com.tc.hibernateApp.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCacheUtil {

	private static SessionFactory factory;

	private HibernateCacheUtil() {

	}

	private static SessionFactory buildSessionFactory() {
		if (factory == null) {
			factory = new Configuration().configure().addAnnotatedClass(NewEmployeeInfoBean.class)
					.buildSessionFactory();
		}
		return factory;
	}

	public static Session openSession() {
		return buildSessionFactory().openSession();
	}
}
