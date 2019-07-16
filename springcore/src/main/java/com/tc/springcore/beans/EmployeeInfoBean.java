package com.tc.springcore.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class EmployeeInfoBean 			//implements InitializingBean,DisposableBean
{
	private int id;
	private String name;
	private DepartmentBean departmentBean;
	public DepartmentBean getDepartmentBean() {
		return departmentBean;
	}
	public void setDepartmentBean(DepartmentBean departmentBean) {
		this.departmentBean = departmentBean;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	@Override
//	public void afterPropertiesSet() throws Exception {			//For Initializing Phase
//		System.out.println("Initilization Phase");
//		
//	}
//	@Override
//	public void destroy() throws Exception {
//		System.out.println("Destroy Phase");
//	}
	@PostConstruct
	public void init() throws Exception {			//For Initializing Phase
		System.out.println("init Phase");
		
	}
	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("Destroy Phase");
	}
	
}
