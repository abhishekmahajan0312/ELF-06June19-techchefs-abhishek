package com.tc.xmlexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tc.xmlexample.dto.DepartmentInfoBean;

public class SaveRecord {
	public static void main(String[] args) {

		DepartmentInfoBean dBean = new DepartmentInfoBean();
		dBean.setId(5);
		dBean.setName("CSE");

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(dBean);
		transaction.commit();
		session.close();
	}

}
