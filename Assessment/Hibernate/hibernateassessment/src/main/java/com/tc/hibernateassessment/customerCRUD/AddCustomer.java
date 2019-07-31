package com.tc.hibernateassessment.customerCRUD;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tc.hibernateassessment.dto.CustomerBean;
import com.tc.hibernateassessment.util.HibernateUtil;

public class AddCustomer {

	public static void main(String[] args) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.openSession()) {
			transaction = session.beginTransaction();
			CustomerBean customerBean = new CustomerBean();
			customerBean.setId(1);
			customerBean.setFName("Abhishek");
			customerBean.setLName("Mahajan");
			customerBean.setContactNumber(9876543210L);
			customerBean.setAddress("8, The Mall");
			customerBean.setCity("Amritsar");
			customerBean.setState("Punjab");
			customerBean.setCountry("India");
			session.save(customerBean);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
