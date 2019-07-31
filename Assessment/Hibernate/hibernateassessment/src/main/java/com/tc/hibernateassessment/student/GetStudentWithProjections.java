package com.tc.hibernateassessment.student;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.tc.hibernateassessment.dto.CustomerBean;
import com.tc.hibernateassessment.dto.ProductsBean;
import com.tc.hibernateassessment.dto.StudentBean;
import com.tc.hibernateassessment.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class GetStudentWithProjections {

	public static void main(String[] args) {

		Session session = HibernateUtil.openSession();
		Criteria criteria = session.createCriteria(StudentBean.class);
		Projection projection1 = Projections.property("firstName");
		Projection projection2 = Projections.property("totalMarks");
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(projection1);
		projectionList.add(projection2);
		
		List<Object[]> list = criteria.list();
		for (Object[] objects : list) {
			
			log.info("First Name " + objects[0]);
			log.info("Total Marks: " + objects[1]);
		}
		session.close();
	}

}
