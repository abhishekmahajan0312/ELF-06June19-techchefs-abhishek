package com.tc.mywebapp.dao;

import java.util.List;

import com.tc.mywebapp.bean.EmployeeInfoBean;

public interface EmployeeDao {
//	ArrayList<EmployeeInfoBean> getAllEmployeeInfo();

	List<EmployeeInfoBean> getAllEmployeeInfo();

	EmployeeInfoBean getEmployeeInfo(String id);

	EmployeeInfoBean getEmployeeInfo(int id);

	boolean createEmployeeInfo(EmployeeInfoBean bean);

	boolean updateEmployeeInfo(EmployeeInfoBean bean);

	boolean deleteEmployeeInfo(int id);

	boolean deleteEmployeeInfo(String id);

}
