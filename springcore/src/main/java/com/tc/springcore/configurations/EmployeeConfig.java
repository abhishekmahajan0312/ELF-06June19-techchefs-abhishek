package com.tc.springcore.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.tc.springcore.beans.DepartmentBean;
import com.tc.springcore.beans.EmployeeInfoBean;

@Configuration
@Import(DepartmentConfig.class)// To import other Config file 
public class EmployeeConfig {
	@Bean
	public EmployeeInfoBean getEmployeeInfoBean() {
		EmployeeInfoBean bean = new EmployeeInfoBean();
		bean.setId(1);
		bean.setName("Abhishek");
		
		return bean;
	}
//	@Bean													//This is if I have only 1 config file
//	public DepartmentBean getDepartmentBean() {
//		DepartmentBean deptBean =  new DepartmentBean();
//		deptBean.setDeptID(101);
//		deptBean.setDeptName("IT");
//		return deptBean;
//	}
}
