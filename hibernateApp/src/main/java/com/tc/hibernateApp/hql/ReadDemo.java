package com.tc.hibernateApp.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.tc.hibernate.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class ReadDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		// HQL query to fetch all the records with all columns
		String hql = "from EmployeeInfoBean";
		// HQL query to fetch all the records with particular column.
		String hql2 = "select name from EmployeeInfoBean";
		// Create Query Object. Query is an interface in hibernate package.
		// createQuery is used for creating the hql query.
//		Query query = session.createQuery(hql);
		Query query = session.createQuery(hql2);
		// With query object we can call 3 function based on the requirement
		// 1. list(): To get all the data from database. It is like select query without
		// condition in SQL.
		// 2. executeUpdate(): To update any data in Table. Like insert, update, delete
		// queries in SQL.
		// 3. uniqueResult(): To get the result based upon some condition from the
		// table. Like select query with
		// where clause in SQL.
//		List<EmployeeInfoBean> beans = query.list();
		List<String> beans = query.list();
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
		for (String ename : beans) {
			log.info("Name:" + ename);
		}
	}
}
