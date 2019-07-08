package com.tc.designpatterns;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	public static void main(String[] args) throws ParseException {
//		EmployeeDao dao = new EmployeeDAOJDBCImpl();
//		printInfo(dao.getEmployeeInfo(1));
//		printInfo(dao.getEmployeeInfo("2"));
		EmployeeDao dao = EmployeeDAOFactory.getInstance();
		List<EmployeeInfoBean> beans = dao.getAllEmployeeInfo();
		for (EmployeeInfoBean bean : beans) {
			printInfo(bean);
		}

//		EmployeeDao dao2 = new EmployeeDAOHibernateImpl();
//		dao = EmployeeDAOFactory.getInstance();
		printInfo(dao.getEmployeeInfo(1));
		printInfo(dao.getEmployeeInfo("2"));

		EmployeeInfoBean empInf = new EmployeeInfoBean();
		empInf.setId(121);
		empInf.setName("Akshay");
		empInf.setAge(25);
		empInf.setGender("male");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse("2012-12-13");

		empInf.setSalary(20000);
		empInf.setPhone(9876543210l);
		empInf.setJoiningDate(date);
		empInf.setAccountNumber(506520102044558l);
		empInf.setEmail("akshay@gmail.com");
		empInf.setDesignation("Software Engineer");

		empInf.setDob(format.parse("1995-02-12"));
		empInf.setDepartmentId(1);
		empInf.setManagerId(5);

		log.info("Inserted the Employee Info? Ans: " + dao.createEmployeeInfo(empInf));
//		dao.deleteEmployeeInfo(121);
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
