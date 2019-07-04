package com.tc.xmlexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tc.xmlexample.dto.DepartmentInfoBean;

public class UpdateRecord {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		DepartmentInfoBean dBean = session.get(DepartmentInfoBean.class, 5);
		dBean.setName("IT");
		Transaction transaction = session.beginTransaction();
		session.update(dBean);
		transaction.commit();
		session.close();
	}

}
