package com.tc.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tc.springcore.beans.CourseBean;
import com.tc.springcore.beans.EmployeeInfoBean;
import com.tc.springcore.beans.MessageBean;

import lombok.extern.java.Log;
@Log
public class CourseTest {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		CourseBean courseBean = (CourseBean)appContext.getBean("courseBean");
		System.out.println("Course ID=" + courseBean.getCourseID());
		System.out.println("Course Name=" + courseBean.getCourseName());
		System.out.println("Faculty =" + courseBean.getFacultyName());
		
	}

}
