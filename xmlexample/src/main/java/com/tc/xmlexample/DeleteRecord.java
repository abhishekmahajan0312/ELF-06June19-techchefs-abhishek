package com.tc.xmlexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tc.xmlexample.dto.DepartmentInfoBean;

public class DeleteRecord {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		DepartmentInfoBean dBean = session.get(DepartmentInfoBean.class, 4);

		Transaction transaction = session.beginTransaction();
		session.delete(dBean);
		transaction.commit();
		session.close();
	}

}
