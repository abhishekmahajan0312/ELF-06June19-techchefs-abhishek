package com.tc.empspringmvc.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAOFactory {

	@Bean(name = "jdbc")
	public static EmployeeDao getInstanceJDBC() {
			 return new EmployeeDAOJDBCImpl();
		
	}// End of getInstance()
	@Bean(name = "hibernate")
	public static EmployeeDao getInstanceHibernate() {
			 return new EmployeeDAOHibernateImpl();
		
	}// End of getInstance()

}// End Of Class
