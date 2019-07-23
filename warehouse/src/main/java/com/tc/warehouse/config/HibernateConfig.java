package com.tc.warehouse.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.tc.warehouse.beans.ItemBean;
@Component
public class HibernateConfig {
	@Bean
	public SessionFactory getSessionFactory() {
		return new Configuration()
				.configure()
				.addAnnotatedClass(ItemBean.class)
				.buildSessionFactory();
	}
	
}
