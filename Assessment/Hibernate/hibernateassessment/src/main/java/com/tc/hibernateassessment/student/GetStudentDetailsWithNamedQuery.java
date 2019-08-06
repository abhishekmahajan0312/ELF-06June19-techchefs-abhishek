package com.tc.hibernateassessment.student;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.tc.hibernateassessment.dto.StudentBean;
import com.tc.hibernateassessment.util.HibernateUtil;

import lombok.extern.java.Log;
@Log
public class GetStudentDetailsWithNamedQuery {

	public static void main(String[] args) {

		Session session = HibernateUtil.openSession();
		String hql = "from StudentBean where rollNum=:rollNum and subject=:subject";
		
		Query query = session.createQuery(hql);
		query.setParameter("rollNum", 123);
		query.setParameter("subject", "science");
		StudentBean bean = (StudentBean)query.uniqueResult();
		log.info("Roll Number: " + bean.getRollNum());
		log.info("First Name: " + bean.getFName());
		log.info("Last Name: " + bean.getLName());
		log.info("Subject: " + bean.getSubject());
		log.info("Total Marks: " + bean.getTotalMarks());
		session.close();
	}
	
}
