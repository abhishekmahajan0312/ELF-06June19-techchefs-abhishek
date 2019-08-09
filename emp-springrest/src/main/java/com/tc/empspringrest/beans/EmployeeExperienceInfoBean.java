package com.tc.empspringrest.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_experienceinfo")
public class EmployeeExperienceInfoBean implements Serializable {
	
	@EmbeddedId
	private EmployeeExperiencePKBean experiencePKBean;
	@Column(name = "designation")
	private String designation;
	@Column(name = "joining_date")
	private Date joiningDate ;
	@Column(name = "releaving_date")
	private Date releavingDate;
}
