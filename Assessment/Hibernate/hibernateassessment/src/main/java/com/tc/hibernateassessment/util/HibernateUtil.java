package com.tc.hibernateassessment.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tc.hibernateassessment.dto.CustomerBean;
import com.tc.hibernateassessment.dto.ProductsBean;
import com.tc.hibernateassessment.dto.StudentBean;
import com.tc.hibernateassessment.dto.StudentInfoBean;
import com.tc.hibernateassessment.dto.StudentOtherInfoBean;
import com.tc.hibernateassessment.dto.TestBean;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private HibernateUtil() {
	}

	private static SessionFactory buildSessionFactory() {
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure().addAnnotatedClass(StudentInfoBean.class).addAnnotatedClass(StudentOtherInfoBean.class).addAnnotatedClass(CustomerBean.class).addAnnotatedClass(EmployeeInfoBean.class).addAnnotatedClass(StudentBean.class).addAnnotatedClass(ProductsBean.class).addAnnotatedClass(TestBean.class).buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public static Session openSession() {
		return buildSessionFactory().openSession();
	}
}
