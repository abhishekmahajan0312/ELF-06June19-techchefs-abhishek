package com.tc.jdbc.beans;

import lombok.Data;

@Data
public class EmployeeOtherInfoBean {
	int id;
	String pan;
	boolean isMarried;
	String bloodGrp;
	boolean isChallenged;
	long emergencyContactNumber;
	long emergencyContactPerson;
	String nationality;
	String religion;
	String fatherNM;
	String motherNM;
	String spouseNM;
	String passport;
	long adhar;
}
