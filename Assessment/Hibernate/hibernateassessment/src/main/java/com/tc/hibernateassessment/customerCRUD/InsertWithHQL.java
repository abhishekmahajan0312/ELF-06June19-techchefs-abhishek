package com.tc.hibernateassessment.customerCRUD;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tc.hibernateassessment.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class InsertWithHQL {
	public static void main(String[] args) {
		
		String hql = "insert into TestBean(id,fName,lName,city) select id,fName,lName,city from CustomerBean where id=1";
		Transaction transaction = null;
		try(Session session = HibernateUtil.openSession()) {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			int result = query.executeUpdate();
			log.info("result:" + result);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} 

	}

}
