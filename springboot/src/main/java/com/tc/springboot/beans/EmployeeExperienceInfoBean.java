package com.tc.springboot.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Entity
@Table(name = "employee_experienceinfo")
@Data
//@XmlRootElement(name = "employee-experience-info")
//@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeExperienceInfoBean implements Serializable {
	
	@EmbeddedId
//	@XmlElement(name="experience-pk")
	private EmployeeExperiencePKBean experiencePKBean;
	@Column(name = "designation")
	private String designation;
//	@XmlElement(name="joining-date")
	@Column(name = "joining_date")
	private Date joiningDate ;
	@Column(name = "releaving_date")
//	@XmlElement(name="releaving-date")
	private Date releavingDate;
	
	
	
}
