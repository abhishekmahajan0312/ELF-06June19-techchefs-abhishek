package com.tc.hibernateassessment.student;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.tc.hibernateassessment.dto.StudentBean;
import com.tc.hibernateassessment.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class GetStudentAgregateDetails {
	public static void main(String[] args) {
		Session session = HibernateUtil.openSession();
		String hql = "select avg(totalmarks) as avgmarks from StudentBean";

		Query query = session.createQuery(hql);
		Object bean = query.getSingleResult();
		log.info("Avg Marks: " + bean);
		hql = "select max(totalmarks) as avgmarks from StudentBean";

		Query query2 = session.createQuery(hql);
		bean = query2.getSingleResult();
		log.info("Max Marks: " + bean);
		hql = "select min(totalmarks) as avgmarks from StudentBean";

		Query query3 = session.createQuery(hql);
		bean = query3.getSingleResult();
		log.info("Min Marks: " + bean);
		session.close();
	}
}
