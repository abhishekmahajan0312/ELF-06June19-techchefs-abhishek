package com.tc.emp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tc.emp.bean.DepartmentInfoBean;
import com.tc.emp.bean.EmployeeInfoBean;
import com.tc.emp.bean.EmployeeOtherInfoBean;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		return new Configuration().configure().addAnnotatedClass(EmployeeInfoBean.class).addAnnotatedClass(DepartmentInfoBean.class).addAnnotatedClass(EmployeeOtherInfoBean.class).buildSessionFactory();

	}

	private static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}

	public static Session openSession() {
		return getSessionFactory().openSession();
	}

}
