package com.tc.hibernatemapping.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tc.hibernatemapping.bean.manytoone.EmployeeAddressInfoBean;
import com.tc.hibernatemapping.bean.manytoone.EmployeeEducationInfoBean;
import com.tc.hibernatemapping.bean.manytoone.EmployeeExperienceInfoBean;
import com.tc.hibernatemapping.bean.manytoone.TrainingInfoBean;
import com.tc.hibernatemapping.bean.onetoone.EmployeeOtherInfoBean;
import com.tc.hibernatemapping.bean.primary.DepartmentInfoBean;
import com.tc.hibernatemapping.bean.primary.EmployeeInfoBean;

public class HibernateImpl {

	private Configuration configuration = new Configuration();
	private SessionFactory sessionFactory = configuration.configure().addAnnotatedClass(DepartmentInfoBean.class).addAnnotatedClass(TrainingInfoBean.class).addAnnotatedClass(EmployeeInfoBean.class).addAnnotatedClass(EmployeeOtherInfoBean.class).addAnnotatedClass(EmployeeAddressInfoBean.class).addAnnotatedClass(EmployeeEducationInfoBean.class).addAnnotatedClass(EmployeeExperienceInfoBean.class).buildSessionFactory();
	public void createEmployee(EmployeeInfoBean infoBean,
			EmployeeOtherInfoBean otherInfoBean,
			List<EmployeeAddressInfoBean> addressInfoBeans,
			List<EmployeeEducationInfoBean> employeeEducationInfoBeans,
			List<EmployeeExperienceInfoBean> experienceInfoBeans) {
		Transaction transaction = null;
		try(Session session = sessionFactory.openSession()){
			transaction = session.beginTransaction();
			session.save(infoBean);
			session.save(otherInfoBean);
			for (EmployeeAddressInfoBean employeeAddressInfoBean : addressInfoBeans) {
				session.save(employeeAddressInfoBean);
			}
			for (EmployeeEducationInfoBean employeeEducationInfoBean : employeeEducationInfoBeans) {
				session.save(employeeEducationInfoBean);
			}
			for (EmployeeExperienceInfoBean employeeExperienceInfoBean : experienceInfoBeans) {
				session.save(employeeExperienceInfoBean);
			}
			transaction.commit();
		}catch(Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		}
	}
	public void createTraining(TrainingInfoBean trainingInfoBean) {
		Transaction transaction = null;
		try(Session session = sessionFactory.openSession()){
			transaction = session.beginTransaction();
			session.save(trainingInfoBean);
			transaction.commit();

		}
	}
	
	public EmployeeInfoBean getEmployeeInfoBean(int id) {
		Session session = sessionFactory.openSession();
		EmployeeInfoBean bean = session.get(EmployeeInfoBean.class, id);
		session.close();
		return bean;
	}
	
	public void createEmployee(EmployeeInfoBean infoBean) {
		Transaction transaction = null;
		try(Session session = sessionFactory.openSession()){
			transaction = session.beginTransaction();
			session.save(infoBean);
			transaction.commit();

		}
	}
}
