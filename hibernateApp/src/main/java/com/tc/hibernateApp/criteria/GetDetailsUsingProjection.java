package com.tc.hibernateApp.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tc.hibernate.util.HibernateUtil;
import com.tc.hibernateApp.dto.EmployeeInfoBean;

import lombok.extern.java.Log;

@Log
public class GetDetailsUsingProjection {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(EmployeeInfoBean.class).add(Restrictions.gt("salary", 10000.0));
		Projection projection = Projections.property("name");
		Projection projection2 = Projections.property("salary");
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(projection).add(projection2);
		criteria.setProjection(projectionList);
		List<Object[]> beans = criteria.list();
//		for (String name : beans) {
//			log.info("Name:" + name);
//		}
		for (Object[] objects : beans) {
			log.info("Name:" + objects[0]);
			log.info("Salary:" + objects[1]);
		}
	}
}
