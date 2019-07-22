package com.tc.springcore;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tc.springcore.beans.EmployeeInfoBean;
import com.tc.springcore.beans.MessageBean;

public class MessageTest{

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		MessageBean messageBean = (MessageBean)appContext.getBean("messageBean");
		System.out.println("in main()" + messageBean.getMessage());
		
//		EmployeeInfoBean empInf = (EmployeeInfoBean)appContext.getBean("employeeInfoBean1");
//		System.out.println("ID:" +empInf.getId());
//		System.out.println("Employee Name: "+empInf.getName());
//		
//		empInf = (EmployeeInfoBean)appContext.getBean("employeeInfoBean2");
//		System.out.println("ID:" +empInf.getId());
//		System.out.println("Employee Name: "+empInf.getName());
		
	}

}
