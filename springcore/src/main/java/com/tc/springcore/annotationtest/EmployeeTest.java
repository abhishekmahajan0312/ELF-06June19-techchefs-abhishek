package com.tc.springcore.annotationtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.tc.springcore.beans.DepartmentBean;
import com.tc.springcore.beans.EmployeeInfoBean;
import com.tc.springcore.beans.MessageBean;
import com.tc.springcore.configurations.DepartmentConfig;
import com.tc.springcore.configurations.EmployeeConfig;
import com.tc.springcore.configurations.MessageConfiguration;

import lombok.extern.java.Log;
@Log
public class EmployeeTest {
	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);//For Annotation Based Mapping
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class,DepartmentConfig.class);//For more than 1 XML
		((ConfigurableApplicationContext)context).registerShutdownHook();
		EmployeeInfoBean employeeBean = context.getBean(EmployeeInfoBean.class);
		
		log.info("ID:"+employeeBean.getId()); //Prints the message
		log.info("Name:"+employeeBean.getName());//Prints the message
		
		DepartmentBean deptBean = employeeBean.getDepartmentBean();
		
		log.info("Department ID:"+deptBean.getDeptID());//Prints the message
		log.info("Department Name:"+deptBean.getDeptName());//Prints the message
		
	}
}
