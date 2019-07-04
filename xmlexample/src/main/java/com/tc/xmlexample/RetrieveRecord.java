package com.tc.xmlexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tc.xmlexample.dto.DepartmentInfoBean;

import lombok.extern.java.Log;

@Log
public class RetrieveRecord {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		DepartmentInfoBean dBean = session.get(DepartmentInfoBean.class, 5);
		log.info("Dept Id===" + dBean.getId());
		log.info("Dept Name===" + dBean.getName());
	}

}
