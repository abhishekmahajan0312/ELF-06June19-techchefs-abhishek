package com.tc.jdbc.beans;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeInfoBean {
	int id;
	String name;
	int age;
	String gender;
	double salary;
	long phone;
	Date joiningDate;
	long accountNumber;
	String email;
	String designation;
	Date dob;
	int deptId;
	int mngrId;
}
