package com.tc.hibernateApp.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.tc.hibernate.util.HibernateUtil;
import com.tc.hibernateApp.dto.EmployeeInfoBean;

import lombok.extern.java.Log;

@Log
public class CriteriaWithRestrictions {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(EmployeeInfoBean.class).add(Restrictions.gt("salary", 10000.0));
//		Criterion criterion = Restrictions.eq("id", 101);
//		criteria.add(criterion);
//		EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) criteria.uniqueResult();
		List<EmployeeInfoBean> beans = criteria.list();

		for (EmployeeInfoBean employeeInfoBean : beans) {
			log.info("ID:" + employeeInfoBean.getId());
			log.info("Name:" + employeeInfoBean.getName());
			log.info("Age:" + employeeInfoBean.getAge());
			log.info("Gender:" + employeeInfoBean.getGender());
			log.info("Salary:" + employeeInfoBean.getSalary());
			log.info("Phone:" + employeeInfoBean.getPhone());
			log.info("Joining Date:" + employeeInfoBean.getJoiningDate());
			log.info("Account Number:" + employeeInfoBean.getAccountNumber());
			log.info("Email:" + employeeInfoBean.getEmail());
			log.info("Designation:" + employeeInfoBean.getDesignation());
			log.info("DOB:" + employeeInfoBean.getDob());
			log.info("Dept ID:" + employeeInfoBean.getDeptId());
			log.info("Manager ID:" + employeeInfoBean.getMngrId());
		}
	}
}
