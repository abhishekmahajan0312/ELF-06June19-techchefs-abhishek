package com.tc.hibernateApp.criteria;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tc.hibernate.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class GetDetailsUsingStoredProcedure {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		StoredProcedureQuery query = session.createStoredProcedureCall("employee_info_sp");
		List<Object[]> beans = query.getResultList();

		for (Object[] employeeInfoBean : beans) {
			log.info("ID:" + employeeInfoBean[0]);
			log.info("Name:" + employeeInfoBean[1]);
			log.info("Age:" + employeeInfoBean[2]);
			log.info("Gender:" + employeeInfoBean[3]);
			log.info("Salary:" + employeeInfoBean[4]);
			log.info("Phone:" + employeeInfoBean[5]);
			log.info("Joining Date:" + employeeInfoBean[6]);
			log.info("Account Number:" + employeeInfoBean[7]);
			log.info("Email:" + employeeInfoBean[8]);
			log.info("Designation:" + employeeInfoBean[9]);
			log.info("DOB:" + employeeInfoBean[10]);
			log.info("Dept ID:" + employeeInfoBean[11]);
			log.info("Manager ID:" + employeeInfoBean[12]);
		}
//		StoredProcedureQuery query = session.createStoredProcedureCall(EmployeeInfoBean.class.getSimpleName());
//		List<EmployeeInfoBean> beans = query.getResultList();
//
//		for (EmployeeInfoBean employeeInfoBean : beans) {
//			log.info("ID:" + employeeInfoBean.getId());
//			log.info("Name:" + employeeInfoBean.getName());
//			log.info("Age:" + employeeInfoBean.getAge());
//			log.info("Gender:" + employeeInfoBean.getGender());
//			log.info("Salary:" + employeeInfoBean.getSalary());
//			log.info("Phone:" + employeeInfoBean.getPhone());
//			log.info("Joining Date:" + employeeInfoBean.getJoiningDate());
//			log.info("Account Number:" + employeeInfoBean.getAccountNumber());
//			log.info("Email:" + employeeInfoBean.getEmail());
//			log.info("Designation:" + employeeInfoBean.getDesignation());
//			log.info("DOB:" + employeeInfoBean.getDob());
//			log.info("Dept ID:" + employeeInfoBean.getDeptId());
//			log.info("Manager ID:" + employeeInfoBean.getMngrId());
//		}
	}
}
