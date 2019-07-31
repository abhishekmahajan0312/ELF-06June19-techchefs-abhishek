package com.tc.hibernateassessment.cache;

import org.hibernate.Session;

import com.tc.hibernateassessment.dto.EmployeeInfoBean;
import com.tc.hibernateassessment.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class GetEmployeeDetailsWithCache {
	public static void main(String[] args) {
		log.info("1st time: " + getEmployeeData(1).toString());
		log.info("2nd time: " + getEmployeeData(1).toString());
		log.info("3rd time: " + getEmployeeData(1).toString());
	}// End Of Main

	private static EmployeeInfoBean getEmployeeData(int id) {

		EmployeeInfoBean bean = null;
		try (Session session = HibernateUtil.openSession();) {
			bean = session.get(EmployeeInfoBean.class, id);
		}
		return bean;
	}// End of getEmployeeData(int)
}// End Of Class
