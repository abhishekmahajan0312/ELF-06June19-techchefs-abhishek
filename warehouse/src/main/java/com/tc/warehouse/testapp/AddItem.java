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

public class AddItem {
	public static void main(String[] args) {
		ItemBean item = PrepareDataUtil.prepareData(103);
		save(item);
	}

	private static void save(ItemBean bean) {
		Transaction transaction = null;
		ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

		SessionFactory factory = context.getBean(SessionFactory.class);

		try (Session session = factory.openSession();) {
			transaction = session.beginTransaction();
			session.save(bean);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} // End of Try-Catch
	}
}
