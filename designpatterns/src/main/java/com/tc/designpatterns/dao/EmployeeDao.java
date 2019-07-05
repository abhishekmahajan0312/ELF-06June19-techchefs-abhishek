package com.tc.designpatterns.dao;

import java.util.ArrayList;

import com.tc.designpatterns.beans.EmployeeInfoBean;

public interface EmployeeDao {
	ArrayList<EmployeeInfoBean> getAllEmployeeInfo();

	EmployeeInfoBean getEmployeeInfo(String id);

	EmployeeInfoBean getEmployeeInfo(int id);
}
