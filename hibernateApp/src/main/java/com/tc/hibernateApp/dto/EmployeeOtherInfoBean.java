package com.tc.hibernateApp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_otherinfo")
public class EmployeeOtherInfoBean implements Serializable {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "pan")
	private String pan;
	@Column(name = "ismarried")
	private boolean isMarried;
	@Column(name = "blood_grp")
	private String bloodGroup;
	@Column(name = "ischallenged")
	private boolean isChallenged;
	@Column(name = "emergency_contact_number")
	private long emergencyCNM;
	@Column(name = "emergency_contact_person")
	private String emergencyCP;
	@Column(name = "nationality")
	private String nationality;
	@Column(name = "religion")
	private String religion;
	@Column(name = "father_nm")
	private String fatherNM;
	@Column(name = "mother_nm")
	private String motherNM;
	@Column(name = "spouse_nm")
	private String spouseNM;
	@Column(name = "passport")
	private String passport;
	@Column(name = "adhar")
	private long adhar;

}
