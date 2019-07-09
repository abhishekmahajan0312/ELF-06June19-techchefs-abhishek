package com.tc.hibernateApp.cache;

import org.hibernate.Session;

import lombok.extern.java.Log;

@Log
public class HibernateCacheTest2 {
	public static void main(String[] args) {
		log.info("1st time: " + getEmployeeData(1).toString());
		log.info("2nd time: " + getEmployeeData(1).toString());
		log.info("3rd time: " + getEmployeeData(1).toString());
	}// End Of Main

	private static NewEmployeeInfoBean getEmployeeData(int id) {

		NewEmployeeInfoBean bean = null;
		try (Session session = HibernateCacheUtil.openSession();) {
			bean = session.get(NewEmployeeInfoBean.class, id);
		}
		return bean;
	}// End of getEmployeeData(int)
}// End Of Class
