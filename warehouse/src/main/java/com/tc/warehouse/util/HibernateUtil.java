package com.tc.warehouse.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tc.warehouse.beans.ItemBean;

import lombok.Data;


@Data
@Component("hibernateUtil")
//@org.springframework.context.annotation.Configuration
public class HibernateUtil {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session openSession() {
		return sessionFactory.openSession();
	}
//	private static SessionFactory sessionFactory;
//
//	private static SessionFactory buildSessionFactory() {
//		return new Configuration()
//				.configure()
//				.addAnnotatedClass(ItemBean.class)
//				.buildSessionFactory();
//		
//	}
//
//	public static SessionFactory getSessionFactory() {
//		if (sessionFactory == null) {
//			sessionFactory = buildSessionFactory();
//		}
//		return sessionFactory;
//	}
//	
//	public static Session openSession() {
//		return getSessionFactory().openSession();
//	}
}
