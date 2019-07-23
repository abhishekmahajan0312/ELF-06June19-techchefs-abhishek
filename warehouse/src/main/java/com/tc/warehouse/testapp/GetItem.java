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
public class GetItem {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		SessionFactory factory = context.getBean(SessionFactory.class);
		Session session = factory.openSession();
		ItemBean item = session.get(ItemBean.class, 103);
		log.info("Item ID=" + item.getItemID());
		log.info("Item Name=" + item.getName());
		log.info("Item Quantity=" + item.getQuantity());
		log.info("Item Description=" + item.getDescription());
		log.info("Item Cost=" + item.getCost());

	}
}
