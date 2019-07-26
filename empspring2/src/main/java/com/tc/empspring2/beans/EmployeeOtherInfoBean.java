package com.tc.empspring2.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_otherinfo")
public class EmployeeOtherInfoBean {
	@Id
	@Column(name = "id")
	int id;
	@Column(name = "pan")
	String pan;
	@Column(name = "ismarried")
	boolean isMarried;
	@Column(name = "blood_grp")
	String bloodGrp;
	@Column(name = "ischallenged")
	boolean isChallenged;
	@Column(name = "emergency_contact_number")
	long emergencyContactNumber;
	@Column(name = "emergency_contact_person")
	String emergencyContactPerson;
	@Column(name = "nationality")
	String nationality;
	@Column(name = "religion")
	String religion;
	@Column(name = "father_nm")
	String fatherNM;
	@Column(name = "mother_nm")
	String motherNM;
	@Column(name = "spouse_nm")
	String spouseNM;
	@Column(name = "passport")
	String passport;
	@Column(name = "adhar")
	long adhar;
}
