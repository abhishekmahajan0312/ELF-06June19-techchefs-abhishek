package com.tc.hibernateApp;

import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tc.hibernate.util.HibernateUtil;
import com.tc.hibernateApp.dto.EmployeeInfoBean;

import lombok.extern.java.Log;

@Log
public class RetrieveRecords {
	public static void main(String[] args) {
//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
////			cfg.addAnnotatedClass(EmployeeInfoBean.class);
//
//		SessionFactory factory = cfg.buildSessionFactory();
//		Session session = factory.openSession();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		EmployeeInfoBean empInf = session.get(EmployeeInfoBean.class, 101);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		log.info("ID=" + empInf.getId());
		log.info("Name=" + empInf.getName());
		log.info("Age=" + empInf.getAge());
		log.info("Gender=" + empInf.getGender());
		log.info("Salary=" + empInf.getSalary());
		log.info("Phone=" + empInf.getPhone());

		log.info("Joining Date=" + format.format(empInf.getJoiningDate()));
		log.info("Account Number=" + empInf.getAccountNumber());
		log.info("Email=" + empInf.getEmail());
		log.info("Designation=" + empInf.getDesignation());
		log.info("DOB=" + format.format(empInf.getDob()));
		log.info("Department Id=" + empInf.getDeptId());
		log.info("Manager Id=" + empInf.getMngrId());

	}
}
