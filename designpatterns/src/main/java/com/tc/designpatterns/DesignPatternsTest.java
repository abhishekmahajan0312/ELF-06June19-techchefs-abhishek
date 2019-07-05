package com.tc.designpatterns;

import com.tc.designpatterns.beans.EmployeeInfoBean;
import com.tc.designpatterns.dao.EmployeeDAOFactory;
import com.tc.designpatterns.dao.EmployeeDao;

import lombok.extern.java.Log;

/**
 * Hello world!
 *
 */
@Log
public class DesignPatternsTest {
	public static void main(String[] args) {
//		EmployeeDao dao = new EmployeeDAOJDBCImpl();
//		printInfo(dao.getEmployeeInfo(1));
//		printInfo(dao.getEmployeeInfo("2"));
//
//		ArrayList<EmployeeInfoBean> beans = dao.getAllEmployeeInfo();
//		for (EmployeeInfoBean bean : beans) {
//			printInfo(bean);
//		}

//		EmployeeDao dao2 = new EmployeeDAOHibernateImpl();
		EmployeeDao dao = EmployeeDAOFactory.getInstance();
		printInfo(dao.getEmployeeInfo(1));
		printInfo(dao.getEmployeeInfo("2"));
	}// End of Main

	private static void printInfo(EmployeeInfoBean bean) {
		log.info("Id: " + bean.getId());
		log.info("Name: " + bean.getName());
		log.info("Age: " + bean.getAge());
		log.info("Gender: " + bean.getGender());
		log.info("Salary: " + bean.getSalary());
		log.info("Phone: " + bean.getPhone());
		log.info("Joining Date: " + bean.getJoiningDate());
		log.info("Account Number: " + bean.getAccountNumber());
		log.info("Email: " + bean.getEmail());
		log.info("Designation:" + bean.getDesignation());
		log.info("DOB:" + bean.getDob());
		log.info("Department Id: " + bean.getDepartmentId());
		log.info("Manager Id: " + bean.getManagerId());
	}// End of Print Method
}
