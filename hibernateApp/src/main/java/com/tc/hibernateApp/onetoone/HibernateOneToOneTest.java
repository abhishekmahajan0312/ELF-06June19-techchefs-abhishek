package com.tc.hibernateApp.onetoone;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tc.hibernate.util.HibernateUtil;
import com.tc.hibernate.util.PrepareDataUtil;

import lombok.extern.java.Log;

@Log
public class HibernateOneToOneTest {
	public static void main(String[] args) {
		// Prepare Data
		int id = 123;
		EmployeeInfoBean data = PrepareDataUtil.prepareData(id);
		save(data);
		
	}// End of Main
	
	private static void save(EmployeeInfoBean infoBean) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.openSession()) {
			transaction = session.beginTransaction();
			session.save(infoBean);
			transaction.commit();
		} catch (Exception e) {
//			log.severe(Arrays.toString(e.getStackTrace()));
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} // End of Try-Catch
	}
}// End of Class
