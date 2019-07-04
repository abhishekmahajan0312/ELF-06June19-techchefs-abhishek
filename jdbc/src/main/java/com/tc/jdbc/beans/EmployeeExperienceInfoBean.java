package com.tc.jdbc.beans;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeExperienceInfoBean {
	int id;
	String companyName;
	String designation;
	Date joiningDate;
	Date releavingDate;
}
