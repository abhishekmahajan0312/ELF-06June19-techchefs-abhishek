package com.tc.empspringrest.beans;

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
	public EmployeeExperiencePKBean getExperiencePKBean() {
		return experiencePKBean;
	}
	public void setExperiencePKBean(EmployeeExperiencePKBean experiencePKBean) {
		this.experiencePKBean = experiencePKBean;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Date getReleavingDate() {
		return releavingDate;
	}
	public void setReleavingDate(Date releavingDate) {
		this.releavingDate = releavingDate;
	}
	
	
}
