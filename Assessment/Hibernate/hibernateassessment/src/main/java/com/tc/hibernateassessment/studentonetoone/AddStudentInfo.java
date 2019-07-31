package com.tc.hibernateassessment.studentonetoone;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tc.hibernateassessment.dto.CustomerBean;
import com.tc.hibernateassessment.dto.StudentInfoBean;
import com.tc.hibernateassessment.dto.StudentOtherInfoBean;
import com.tc.hibernateassessment.util.HibernateUtil;

public class AddStudentInfo {

	public static void main(String[] args) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.openSession()) {
			transaction = session.beginTransaction();
			StudentInfoBean studentBean = new StudentInfoBean();
			studentBean.setRollNum(1);
			studentBean.setName("Abhishek");
			studentBean.setAge(29);
			studentBean.setGender("Male");
			studentBean.setMobileNo(9875644125L);
			studentBean.setEmailId("abhi@gmail.com");
			
			StudentOtherInfoBean otherBean = new StudentOtherInfoBean();
			otherBean.setRollNum(1);
			otherBean.setFatherNM("HK");
			otherBean.setMotherNM("Sunita");
			otherBean.setReligion("Hindu");
			otherBean.setNationality("India");
			studentBean.setOtherInfo(otherBean);
			session.save(studentBean);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
