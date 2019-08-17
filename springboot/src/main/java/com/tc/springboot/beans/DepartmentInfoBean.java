package com.tc.springboot.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
@Entity
@Table(name="department_info")
@Data
//@XmlRootElement(name="department-info")
//@XmlAccessorType(XmlAccessType.FIELD)
public class DepartmentInfoBean implements Serializable {

	@Id
	@Column(name="dept_id")
//	@XmlElement(name="department-id")
	private int departmentId;
	
	@Column(name="dept_name")
//	@XmlElement(name="department-name")
	private String departmentName;

}
