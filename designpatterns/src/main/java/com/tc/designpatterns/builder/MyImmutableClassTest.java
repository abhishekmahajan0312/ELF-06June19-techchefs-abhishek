package com.tc.designpatterns.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.java.Log;

@Log
public class MyImmutableClassTest {

	public static void main(String[] args) throws ParseException {
		MyImmutableClass immutableClass = null;
		immutableClass = new MyImmutableClass("ABC", 16, 9876543210L);
		log.info("Name: " + immutableClass.getName());
		log.info("Age: " + immutableClass.getAge());
		log.info("Phone: " + immutableClass.getPhone());

		immutableClass = new MyImmutableClass("XYZ", 16, 11445566998L);
		log.info("Name: " + immutableClass.getName());
		log.info("Age: " + immutableClass.getAge());
		log.info("Phone: " + immutableClass.getPhone());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = format.parse("2015-02-12");
		EmployeeData data = new EmployeeData(1, "Danish", 25, "male", 1000, 9876543210l, format.parse("2015-02-12"),
				7889456123012l, "danish@gmail.com", "Software Developer", format.parse("2000-12-12"), 1, 2);

		log.info("Employee Info : " + data.toString());

		EmployeeData2 data2 = new EmployeeData2.EmployeeData2Builder().id(1).name("Danish").age(25).gender("male")
				.salary(1000).phone(9876543210l).joiningDate(d).accountNumber(789456423111l).email("danish@gmail.com")
				.designation("Software Developer").dob(d).departmentId(2).managerId(5).build();

		log.info("Employee Info : " + data2.toString());

		EmployeeData3 data3 = new EmployeeData3.EmployeeData3Builder().id(1).name("Danish").age(25).gender("male")
				.salary(1000).phone(9876543210l).joiningDate(d).accountNumber(789456423111l)
				.email("danish123@gmail.com").designation("Software").dob(d).departmentId(2).managerId(5).build();

		log.info("Employee Info : " + data3.toString());

	}// End of main
}// End of Class
