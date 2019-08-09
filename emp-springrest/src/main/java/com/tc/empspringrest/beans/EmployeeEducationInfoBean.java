package com.tc.empspringrest.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_educationinfo")
public class EmployeeEducationInfoBean implements Serializable {
	
	@EmbeddedId
	private EmployeeEducationPKBean educationPKBean;
	@Column(name = "degree_type")
	private String degreeType;
	@Column(name = "college_nm")
	private String collegeNM;
	@Column(name = "university")
	private String university;
	@Column(name = "yop")
	private String yop;
	@Column(name = "percentage")
	private String percentage;
	@Column(name = "location")
	private String location;
}
