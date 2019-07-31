package com.tc.hibernateassessment.customerCRUD;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tc.hibernateassessment.dto.CustomerBean;
import com.tc.hibernateassessment.util.HibernateUtil;

public class DeleteCustomer {

	public static void main(String[] args) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.openSession()) {
			transaction = session.beginTransaction();
			CustomerBean customerBean = session.get(CustomerBean.class, 1);
			session.delete(customerBean);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
