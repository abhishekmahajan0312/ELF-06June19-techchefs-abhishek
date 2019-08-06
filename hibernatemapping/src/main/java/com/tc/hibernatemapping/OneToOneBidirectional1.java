package com.tc.hibernatemapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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

public class OneToOneBidirectional1 {

	public static void main(String[] args) {
		try {
			EmployeeInfoBean empInf = new EmployeeInfoBean();
			empInf.setId(2);
			empInf.setName("Akshay");
			empInf.setAge(25);
			empInf.setGender("male");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse("2012-12-13");

			empInf.setSalary(20000);
			empInf.setPhone(9876543210l);
			empInf.setJoiningDate(date);
			empInf.setAccountNumber(506520102044558l);
			empInf.setEmail("akshay@gmail.com");
			empInf.setDesignation("Software Engineer");

			empInf.setDob(format.parse("1995-02-12"));
			
			EmployeeOtherInfoBean empOthInfo = new EmployeeOtherInfoBean();
			empOthInfo.setPan("DPDJF9988L");
			empOthInfo.setMarried(true);
			empOthInfo.setBloodGroup("B+");
			empOthInfo.setChallenged(false);
			empOthInfo.setEmergencyCNM(7894561230l);
			empOthInfo.setEmergencyCP("Paul");
			empOthInfo.setNationality("Indian");
			empOthInfo.setReligion("Sikh");
			empOthInfo.setFatherNM("Harsh");
			empOthInfo.setMotherNM("Madhu");
			empOthInfo.setSpouseNM("Diksha");
			empOthInfo.setPassport("M12388923");
			empOthInfo.setAdhar(778845515223l);
			empOthInfo.setInfoBean(empInf);
			
			EmployeeAddressPKBean addressPKBean1 = new EmployeeAddressPKBean();
			addressPKBean1.setAddressType("T");
			addressPKBean1.setInfoBean(empInf);
			
			EmployeeAddressPKBean addressPKBean2 = new EmployeeAddressPKBean();
			addressPKBean2.setAddressType("P");
			addressPKBean2.setInfoBean(empInf);
			
			EmployeeAddressInfoBean addressInfoBean1 = new EmployeeAddressInfoBean();
			addressInfoBean1.setAddressPKBean(addressPKBean1);
			addressInfoBean1.setAddress1("Bellandur");
			addressInfoBean1.setAddress2("Green Glen Layout");
			addressInfoBean1.setCity("Bangalore");
			addressInfoBean1.setState("Karnataka");
			addressInfoBean1.setCountry("India");
			addressInfoBean1.setLandmark("Joggers Park");
			addressInfoBean1.setPin(560103);

			EmployeeAddressInfoBean addressInfoBean2 = new EmployeeAddressInfoBean();
			addressInfoBean2.setAddressPKBean(addressPKBean2);
			addressInfoBean2.setAddress1("Gurbax Nagar");
			addressInfoBean2.setAddress2("Nawakot");
			addressInfoBean2.setCity("Amritsar");
			addressInfoBean2.setState("Punjab");
			addressInfoBean2.setCountry("India");
			addressInfoBean2.setLandmark("Sharma Hospital");
			addressInfoBean2.setPin(143001);

			EmployeeEducationPKBean employeeEducationPKBean1 = new EmployeeEducationPKBean();
			employeeEducationPKBean1.setInfoBean(empInf);
			employeeEducationPKBean1.setEducationalType("B.Tech.");
			
			EmployeeEducationPKBean employeeEducationPKBean2 = new EmployeeEducationPKBean();
			employeeEducationPKBean2.setInfoBean(empInf);
			employeeEducationPKBean2.setEducationalType("M.Tech.");
			
			EmployeeEducationInfoBean employeeEducationInfoBean1 = new EmployeeEducationInfoBean();
			employeeEducationInfoBean1.setEducationPKBean(employeeEducationPKBean1);
			employeeEducationInfoBean1.setCollegeNM("ACET");
			employeeEducationInfoBean1.setUniversity("PTU");
			employeeEducationInfoBean1.setYop("2013");
			employeeEducationInfoBean1.setPercentage("78%");
			employeeEducationInfoBean1.setLocation("Amritsar");
			
			EmployeeEducationInfoBean employeeEducationInfoBean2 = new EmployeeEducationInfoBean();
			employeeEducationInfoBean2.setEducationPKBean(employeeEducationPKBean2);
			employeeEducationInfoBean2.setCollegeNM("IIT");
			employeeEducationInfoBean2.setUniversity("IIT");
			employeeEducationInfoBean2.setYop("2017");
			employeeEducationInfoBean2.setPercentage("84%");
			employeeEducationInfoBean2.setLocation("Amritsar");
			
			EmployeeExperiencePKBean experiencePKBean1 = new EmployeeExperiencePKBean();
			experiencePKBean1.setInfoBean(empInf);
			experiencePKBean1.setCompanyName("VMM");
			
			EmployeeExperiencePKBean experiencePKBean2 = new EmployeeExperiencePKBean();
			experiencePKBean2.setInfoBean(empInf);
			experiencePKBean2.setCompanyName("Techchefs");
			
			EmployeeExperienceInfoBean experienceInfoBean1 = new EmployeeExperienceInfoBean();
			experienceInfoBean1.setExperiencePKBean(experiencePKBean1);
			experienceInfoBean1.setDesignation("Software Developer");
			experienceInfoBean1.setJoiningDate(format.parse("2013-08-12"));
			experienceInfoBean1.setReleavingDate(format.parse("2015-09-01"));
			
			EmployeeExperienceInfoBean experienceInfoBean2 = new EmployeeExperienceInfoBean();
			experienceInfoBean2.setExperiencePKBean(experiencePKBean2);
			experienceInfoBean2.setDesignation("Technology Lead");
			experienceInfoBean2.setJoiningDate(format.parse("2019-07-01"));
			experienceInfoBean2.setReleavingDate(format.parse("2025-09-01"));
			
			TrainingInfoBean trainingInfoBean1 = new TrainingInfoBean();
			trainingInfoBean1.setCourseId(101);
			trainingInfoBean1.setCourseName("Java");
			trainingInfoBean1.setCourseType("Full Time");
			trainingInfoBean1.setDuration("6 months");
			trainingInfoBean1.setInfoBeans(Arrays.asList(empInf));
			
			
			TrainingInfoBean trainingInfoBean2 = new TrainingInfoBean();
			trainingInfoBean2.setCourseId(102);
			trainingInfoBean2.setCourseName("PHP");
			trainingInfoBean2.setCourseType("Full Time");
			trainingInfoBean2.setDuration("6 months");
			trainingInfoBean2.setInfoBeans(Arrays.asList(empInf));
			
			empInf.setEmployeeOtherInfoBean(empOthInfo);
			empInf.setAddressInfoBeans(Arrays.asList(addressInfoBean1,addressInfoBean2));
			empInf.setEducationInfoBeans(Arrays.asList(employeeEducationInfoBean1,employeeEducationInfoBean2));
			empInf.setExperienceInfoBeans(Arrays.asList(experienceInfoBean1,experienceInfoBean2));
			empInf.setTrainingInfoBeans(Arrays.asList(trainingInfoBean1,trainingInfoBean2));
			HibernateImpl impl = new HibernateImpl();
			impl.createEmployee(empInf);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
