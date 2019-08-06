package com.tc.empspringmvc.dao;

import java.util.List;

import com.tc.empspringmvc.beans.EmployeeInfoBean;

public interface EmployeeDao {
//	ArrayList<EmployeeInfoBean> getAllEmployeeInfo();

	List<EmployeeInfoBean> getAllEmployeeInfo();

	EmployeeInfoBean getEmployeeInfo(String id);

	EmployeeInfoBean getEmployeeInfo(int id);

	boolean createEmployeeInfo(EmployeeInfoBean bean);

	boolean updateEmployeeInfo(EmployeeInfoBean bean);

	boolean deleteEmployeeInfo(int id);

	boolean deleteEmployeeInfo(String id);
	
	public List<EmployeeInfoBean> getAllEmployeeInfoWithRestrictions(String condition);
	
	public List<EmployeeInfoBean> getAllEmployeeInfoWithRestrictions(int condition);

}
