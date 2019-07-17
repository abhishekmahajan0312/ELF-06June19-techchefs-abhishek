package com.tc.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tc.springcore.beans.EmployeeInfoBean;

import lombok.extern.java.Log;
@Log
public class EmployeeTest {

	public static void main(String[] args) {
//		ApplicationContext appContext = new ClassPathXmlApplicationContext("employeebeans.xml");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("importAllConfig.xml");
		
//		EmployeeInfoBean empInf = (EmployeeInfoBean)appContext.getBean("employeeInfoBean1");
//		Scanner sc = new Scanner(System.in);
//		log.info("Enter Employee 1 is: ");
//		empInf.setId(sc.nextInt());
//		sc.nextLine();
//		log.info("Enter Employee 1 Name: ");
//		empInf.setName(sc.nextLine());
//		EmployeeInfoBean empInf2 = (EmployeeInfoBean)appContext.getBean("employeeInfoBean1");
//		
//		log.info("Enter Employee 2 is: ");
//		empInf2.setId(sc.nextInt());
//		sc.nextLine();
//		log.info("Enter Employee 2 Name: ");
//		empInf2.setName(sc.nextLine());
//		
		EmployeeInfoBean empBean = (EmployeeInfoBean)appContext.getBean("employeeInfoBean1");
		
		log.info("ID:" +empBean.getId());
		log.info("Employee Name: "+empBean.getName());
		
		
		log.info("Department ID:" +empBean.getDepartmentBean().getDeptID());
		log.info("Department Name: "+empBean.getDepartmentBean().getDeptName());
//		sc.close();
		
//		((AbstractApplicationContext)appContext).registerShutdownHook();    //This doesnot close when the user call this fn.Behaves same as gc(). 
	}

}
