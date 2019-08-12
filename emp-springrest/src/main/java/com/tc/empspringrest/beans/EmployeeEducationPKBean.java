package com.tc.empspringrest.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;


@SuppressWarnings("serial")
@Embeddable
@XmlRootElement(name = "employee-education-pk")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeEducationPKBean implements Serializable{

	@JoinColumn(name = "id")
	@ManyToOne
	@XmlTransient
	private EmployeeInfoBean infoBean;
	@Column(name = "educational_type")
	@XmlElement(name="educational-type")
	private String educationalType;
	public EmployeeInfoBean getInfoBean() {
		return infoBean;
	}
	public void setInfoBean(EmployeeInfoBean infoBean) {
		this.infoBean = infoBean;
	}
	public String getEducationalType() {
		return educationalType;
	}
	public void setEducationalType(String educationalType) {
		this.educationalType = educationalType;
	}
	
}
