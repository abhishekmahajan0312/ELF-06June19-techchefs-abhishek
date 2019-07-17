package com.tc.springcore.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.tc.springcore.beans.DepartmentBean;
import com.tc.springcore.beans.EmployeeInfoBean;

@Configuration
public class DepartmentConfig {
	@Bean(name="it")
	public DepartmentBean getDepartmentITBean() {
		DepartmentBean deptBean =  new DepartmentBean();
		deptBean.setDeptID(101);
		deptBean.setDeptName("IT");
		return deptBean;
	}
	
	@Bean(name="hr")
	//@Primary //1st Method To set which bean to autowire
	public DepartmentBean getDepartmentHRBean() {
		DepartmentBean deptBean =  new DepartmentBean();
		deptBean.setDeptID(102);
		deptBean.setDeptName("HR");
		return deptBean;
	}
	
	@Bean(name="testing")
	public DepartmentBean getDepartmentTestingBean() {
		DepartmentBean deptBean =  new DepartmentBean();
		deptBean.setDeptID(103);
		deptBean.setDeptName("Testing");
		return deptBean;
	}
}
