package com.tc.hibernateassessment.product;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;

import com.tc.hibernateassessment.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class GetDetailsUsingStoredProcedure {
	public static void main(String[] args) {
		Session session = HibernateUtil.openSession();
		StoredProcedureQuery query = session.createStoredProcedureCall("student_sp");
		List<Object[]> beans = query.getResultList();

		for (Object[] studentBean : beans) {
			log.info("ID:" + studentBean[0]);
			log.info("Name:" + studentBean[1]);
			log.info("Age:" + studentBean[2]);
			log.info("Gender:" + studentBean[3]);
			log.info("Salary:" + studentBean[4]);
		}
	}
}
