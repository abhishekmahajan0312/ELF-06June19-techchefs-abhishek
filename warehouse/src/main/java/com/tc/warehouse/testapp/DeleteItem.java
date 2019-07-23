package com.tc.warehouse.testapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tc.warehouse.beans.ItemBean;
import com.tc.warehouse.config.HibernateConfig;
import com.tc.warehouse.util.HibernateUtil;
import com.tc.warehouse.util.PrepareDataUtil;

import lombok.extern.java.Log;

@Log
public class DeleteItem {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		SessionFactory factory = context.getBean(SessionFactory.class);
		Transaction transaction = null;
		try (Session session = factory.openSession();) {
			ItemBean item = session.get(ItemBean.class, 102);
			transaction = session.beginTransaction();
			session.delete(item);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} // End of Try-Catch
	}
}
