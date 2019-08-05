package com.tc.hibernatemapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import com.tc.hibernatemapping.bean.manytoone.EmployeeAddressInfoBean;
import com.tc.hibernatemapping.bean.manytoone.EmployeeAddressPKBean;
import com.tc.hibernatemapping.bean.manytoone.EmployeeEducationInfoBean;
import com.tc.hibernatemapping.bean.manytoone.EmployeeEducationPKBean;
import com.tc.hibernatemapping.bean.manytoone.EmployeeExperienceInfoBean;
import com.tc.hibernatemapping.bean.manytoone.EmployeeExperiencePKBean;
import com.tc.hibernatemapping.bean.manytoone.TrainingInfoBean;
import com.tc.hibernatemapping.bean.onetoone.EmployeeOtherInfoBean;
import com.tc.hibernatemapping.bean.primary.EmployeeInfoBean;
import com.tc.hibernatemapping.model.HibernateImpl;

public class App 
{
    public static void main( String[] args )
    {
    	try {
			EmployeeInfoBean empInf1 = new EmployeeInfoBean();
			empInf1.setId(4);
			empInf1.setName("Akshay");
			empInf1.setAge(25);
			empInf1.setGender("male");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse("2012-12-13");

			empInf1.setSalary(20000);
			empInf1.setPhone(9876543210l);
			empInf1.setJoiningDate(date);
			empInf1.setAccountNumber(506520102044558l);
			empInf1.setEmail("akshay@gmail.com");
			empInf1.setDesignation("Software Engineer");

			empInf1.setDob(format.parse("1995-02-12"));
			empInf1.setDeptId(1);
			empInf1.setMngrId(5);
			
			EmployeeInfoBean empInf2 = new EmployeeInfoBean();
			empInf2.setId(5);
			empInf2.setName("Akshay");
			empInf2.setAge(25);
			empInf2.setGender("male");
			format = new SimpleDateFormat("yyyy-MM-dd");
			date = format.parse("2012-12-13");

			empInf2.setSalary(20000);
			empInf2.setPhone(9876543210l);
			empInf2.setJoiningDate(date);
			empInf2.setAccountNumber(506520102044558l);
			empInf2.setEmail("akshay@gmail.com");
			empInf2.setDesignation("Software Engineer");

			empInf2.setDob(format.parse("1995-02-12"));
			empInf2.setDeptId(1);
			empInf2.setMngrId(5);
			
			
			EmployeeInfoBean empInf3 = new EmployeeInfoBean();
			empInf3.setId(6);
			empInf3.setName("Akshay");
			empInf3.setAge(25);
			empInf3.setGender("male");
			format = new SimpleDateFormat("yyyy-MM-dd");
			date = format.parse("2012-12-13");

			empInf3.setSalary(20000);
			empInf3.setPhone(9876543210l);
			empInf3.setJoiningDate(date);
			empInf3.setAccountNumber(506520102044558l);
			empInf3.setEmail("akshay@gmail.com");
			empInf3.setDesignation("Software Engineer");

			empInf3.setDob(format.parse("1995-02-12"));
			empInf3.setDeptId(1);
			empInf3.setMngrId(5);
			
			TrainingInfoBean trainingInfoBean = new TrainingInfoBean();
			trainingInfoBean.setCourseId(101);
			trainingInfoBean.setCourseName("Java");
			trainingInfoBean.setCourseType("Full Time");
			trainingInfoBean.setDuration("6 months");
			trainingInfoBean.setInfoBeans(Arrays.asList(empInf1,empInf2,empInf3));
			HibernateImpl impl = new HibernateImpl();
			impl.createTraining(trainingInfoBean);
			
//			EmployeeInfoBean empInf = new EmployeeInfoBean();
//			empInf.setId(2);
//			empInf.setName("Akshay");
//			empInf.setAge(25);
//			empInf.setGender("male");
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			Date date = format.parse("2012-12-13");
//
//			empInf.setSalary(20000);
//			empInf.setPhone(9876543210l);
//			empInf.setJoiningDate(date);
//			empInf.setAccountNumber(506520102044558l);
//			empInf.setEmail("akshay@gmail.com");
//			empInf.setDesignation("Software Engineer");
//
//			empInf.setDob(format.parse("1995-02-12"));
//			empInf.setDeptId(1);
//			empInf.setMngrId(5);
//			
//			EmployeeOtherInfoBean empOthInfo = new EmployeeOtherInfoBean();
//			empOthInfo.setPan("DPDJF9988L");
//			empOthInfo.setMarried(true);
//			empOthInfo.setBloodGroup("B+");
//			empOthInfo.setChallenged(false);
//			empOthInfo.setEmergencyCNM(7894561230l);
//			empOthInfo.setEmergencyCP("Paul");
//			empOthInfo.setNationality("Indian");
//			empOthInfo.setReligion("Sikh");
//			empOthInfo.setFatherNM("Harsh");
//			empOthInfo.setMotherNM("Madhu");
//			empOthInfo.setSpouseNM("Diksha");
//			empOthInfo.setPassport("M12388923");
//			empOthInfo.setAdhar(778845515223l);
//			empOthInfo.setInfoBean(empInf);
//			
//			EmployeeAddressPKBean addressPKBean1 = new EmployeeAddressPKBean();
//			addressPKBean1.setAddressType("T");
//			addressPKBean1.setInfoBean(empInf);
//			
//			EmployeeAddressPKBean addressPKBean2 = new EmployeeAddressPKBean();
//			addressPKBean2.setAddressType("P");
//			addressPKBean2.setInfoBean(empInf);
//			
//			EmployeeAddressInfoBean addressInfoBean1 = new EmployeeAddressInfoBean();
//			addressInfoBean1.setAddressPKBean(addressPKBean1);
//			addressInfoBean1.setAddress1("Bellandur");
//			addressInfoBean1.setAddress2("Green Glen Layout");
//			addressInfoBean1.setCity("Bangalore");
//			addressInfoBean1.setState("Karnataka");
//			addressInfoBean1.setCountry("India");
//			addressInfoBean1.setLandmark("Joggers Park");
//			addressInfoBean1.setPin(560103);
//
//			EmployeeAddressInfoBean addressInfoBean2 = new EmployeeAddressInfoBean();
//			addressInfoBean2.setAddressPKBean(addressPKBean2);
//			addressInfoBean2.setAddress1("Gurbax Nagar");
//			addressInfoBean2.setAddress2("Nawakot");
//			addressInfoBean2.setCity("Amritsar");
//			addressInfoBean2.setState("Punjab");
//			addressInfoBean2.setCountry("India");
//			addressInfoBean2.setLandmark("Sharma Hospital");
//			addressInfoBean2.setPin(143001);
//
//			EmployeeEducationPKBean employeeEducationPKBean1 = new EmployeeEducationPKBean();
//			employeeEducationPKBean1.setInfoBean(empInf);
//			employeeEducationPKBean1.setEducationalType("B.Tech.");
//			
//			EmployeeEducationPKBean employeeEducationPKBean2 = new EmployeeEducationPKBean();
//			employeeEducationPKBean2.setInfoBean(empInf);
//			employeeEducationPKBean2.setEducationalType("M.Tech.");
//			
//			EmployeeEducationInfoBean employeeEducationInfoBean1 = new EmployeeEducationInfoBean();
//			employeeEducationInfoBean1.setEducationPKBean(employeeEducationPKBean1);
//			employeeEducationInfoBean1.setCollegeNM("ACET");
//			employeeEducationInfoBean1.setUniversity("PTU");
//			employeeEducationInfoBean1.setYop("2013");
//			employeeEducationInfoBean1.setPercentage("78%");
//			employeeEducationInfoBean1.setLocation("Amritsar");
//			
//			EmployeeEducationInfoBean employeeEducationInfoBean2 = new EmployeeEducationInfoBean();
//			employeeEducationInfoBean2.setEducationPKBean(employeeEducationPKBean2);
//			employeeEducationInfoBean2.setCollegeNM("IIT");
//			employeeEducationInfoBean2.setUniversity("IIT");
//			employeeEducationInfoBean2.setYop("2017");
//			employeeEducationInfoBean2.setPercentage("84%");
//			employeeEducationInfoBean2.setLocation("Amritsar");
//			
//			EmployeeExperiencePKBean experiencePKBean1 = new EmployeeExperiencePKBean();
//			experiencePKBean1.setInfoBean(empInf);
//			experiencePKBean1.setCompanyName("VMM");
//			
//			EmployeeExperiencePKBean experiencePKBean2 = new EmployeeExperiencePKBean();
//			experiencePKBean2.setInfoBean(empInf);
//			experiencePKBean2.setCompanyName("Techchefs");
//			
//			EmployeeExperienceInfoBean experienceInfoBean1 = new EmployeeExperienceInfoBean();
//			experienceInfoBean1.setExperiencePKBean(experiencePKBean1);
//			experienceInfoBean1.setDesignation("Software Developer");
//			experienceInfoBean1.setJoiningDate(format.parse("2013-08-12"));
//			experienceInfoBean1.setReleavingDate(format.parse("2015-09-01"));
//			
//			EmployeeExperienceInfoBean experienceInfoBean2 = new EmployeeExperienceInfoBean();
//			experienceInfoBean2.setExperiencePKBean(experiencePKBean2);
//			experienceInfoBean2.setDesignation("Technology Lead");
//			experienceInfoBean2.setJoiningDate(format.parse("2019-07-01"));
//			experienceInfoBean2.setReleavingDate(format.parse("2025-09-01"));
//			
//			HibernateImpl impl = new HibernateImpl();
//			impl.createEmployee(empInf, empOthInfo,Arrays.asList(addressInfoBean1,addressInfoBean2),Arrays.asList(employeeEducationInfoBean1,employeeEducationInfoBean2),
//					Arrays.asList(experienceInfoBean1,experienceInfoBean2));
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
}
