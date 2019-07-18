package com.tc.emp.dao;

public class EmployeeDAOFactory {

	private static String dbInteractionType = "hibernate";

	private EmployeeDAOFactory() {
	}

	public static EmployeeDao getInstance() {
		EmployeeDao dao = null;
		if (dbInteractionType.equals("jdbc")) {
			dao = new EmployeeDAOJDBCImpl();
		} else if (dbInteractionType.equals("hibernate")) {
			dao = new EmployeeDAOHibernateImpl();
		}
		return dao;
	}// End of getInstance()

}// End Of Class
