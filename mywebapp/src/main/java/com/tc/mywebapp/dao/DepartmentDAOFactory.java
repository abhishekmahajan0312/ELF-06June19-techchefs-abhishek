package com.tc.mywebapp.dao;

public class DepartmentDAOFactory {

	private static String dbInteractionType = "hibernate";

	private DepartmentDAOFactory() {
	}

	public static DepartmentDao getInstance() {
		DepartmentDAOHibernateImpl dao = null;
		if (dbInteractionType.equals("jdbc")) {
//			dao = new DepartmentDAOJDBCImpl();
		} else if (dbInteractionType.equals("hibernate")) {
			dao = new DepartmentDAOHibernateImpl();
		}
		return dao;
	}// End of getInstance()

}// End Of Class
