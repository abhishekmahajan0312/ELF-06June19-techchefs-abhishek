package com.tc.springcore.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeeInfoBean // 1st Method for init and destroy implements InitializingBean,DisposableBean
{
	private int id;
	private String name;
	@Autowired
	@Qualifier("testing")
	private DepartmentBean departmentBean;

//	public EmployeeInfoBean(int id, String name, DepartmentBean departmentBean) { // This is created when autowiring is set to constructor
//		this.id = id;
//		this.name = name;
//		this.departmentBean = departmentBean;
//	}

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

//	@Override    //1st Method for init and destroy continued
//	public void afterPropertiesSet() throws Exception {			//For Initializing Phase
//		System.out.println("Initilization Phase");
//		
//	}
//	@Override
//	public void destroy() throws Exception {
//		System.out.println("Destroy Phase");
//	}
	
//	public void init() throws Exception{ // 2nd Method for init and destroy and give Entry in config.xml file
//		System.out.println("init Phase");
//
//	}
//
//	public void destroy() throws Exception{
//		System.out.println("Destroy Phase");
//	}
	
	@PostConstruct   //3rd Method for init and destroy using Annotations
	public void init() throws Exception { // For Initializing Phase
		System.out.println("init Phase");

	}

	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("Destroy Phase");
	}

}
