package com.tc.hibernateassessment.customerCRUD;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tc.hibernateassessment.dto.CustomerBean;
import com.tc.hibernateassessment.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class ViewCustomer {

	public static void main(String[] args) {

		Session session = HibernateUtil.openSession();
		CustomerBean customerBean = session.get(CustomerBean.class, 1);
		log.info("Customer Id: " + customerBean.getId());
		log.info("Customer Name: " + customerBean.getFName() + " " + customerBean.getLName());
		log.info("Customer Contact Number: " + customerBean.getContactNumber());
		log.info("Customer Address: " + customerBean.getAddress());
		log.info("Customer City: " + customerBean.getCity());
		log.info("Customer State: " + customerBean.getState());
		log.info("Customer Country: " + customerBean.getCountry());
		session.close();
	}

}
