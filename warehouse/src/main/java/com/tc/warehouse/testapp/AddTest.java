package com.tc.warehouse.testapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tc.warehouse.beans.ItemBean;
import com.tc.warehouse.config.HibernateConfig;
import com.tc.warehouse.util.HibernateUtil;
import com.tc.warehouse.util.PrepareDataUtil;

public class AddTest {
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	Transaction transaction = null;
	
	ItemBean item = PrepareDataUtil.prepareData(47564);
	try (Session session = context.getBean("hibernateUtil",HibernateUtil.class).openSession();) {
		transaction = session.beginTransaction();
		session.save(item);
		transaction.commit();
	} catch (Exception e) {
		e.printStackTrace();
		if (transaction != null)
			transaction.rollback();
	} // End of Try-Catch
}
}
