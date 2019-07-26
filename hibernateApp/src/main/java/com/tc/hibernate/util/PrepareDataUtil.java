package com.tc.hibernate.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tc.hibernateApp.onetoone.EmployeeInfoBean;
import com.tc.hibernateApp.onetoone.EmployeeOtherInfoBean;

public class PrepareDataUtil {

	private PrepareDataUtil() {}

	public static EmployeeInfoBean prepareData(int id) {
		
		try {
			EmployeeInfoBean empInf = new EmployeeInfoBean();
			empInf.setId(id);
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
			empInf.setManagerId(1);
			empInf.setDepartmentId(5);
			empInf.setPassword("12345");
			
			EmployeeOtherInfoBean empOthInfo = new EmployeeOtherInfoBean();
//			empOthInfo.setId(id);
			empOthInfo.setPan("DPDJF9988L");
			empOthInfo.setMarried(true);
			empOthInfo.setBloodGrp("B+");
			empOthInfo.setChallenged(false);
			empOthInfo.setEmergencyContactNumber(7894561230l);
			empOthInfo.setEmergencyContactPerson("Paul");
			empOthInfo.setNationality("Indian");
			empOthInfo.setReligion("Sikh");
			empOthInfo.setFatherNM("Harsh");
			empOthInfo.setMotherNM("Madhu");
			empOthInfo.setSpouseNM("Diksha");
			empOthInfo.setPassport("M12388923");
			empOthInfo.setAdhar(778845515223l);
			
			empInf.setOtherInfo(empOthInfo);
			return empInf;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			log.severe(Arrays.toString(e.printStackTrace()));
			return null;
		}
		
		
	}
}//End of Class
