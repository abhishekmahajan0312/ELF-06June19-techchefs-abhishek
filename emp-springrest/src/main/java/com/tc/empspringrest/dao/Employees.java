package com.tc.empspringrest.dao;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.tc.empspringrest.beans.EmployeeInfoBean;

import lombok.Data;

//import lombok.Data;

@XmlRootElement(name = "employees")
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {
	@XmlElement(name = "employee")
	private List<EmployeeInfoBean> allEmployees;

	/*
	 * public List<EmployeeInfoBean> getAllEmployees() { return allEmployees; }
	 * 
	 * public void setAllEmployees(List<EmployeeInfoBean> allEmployees) {
	 * this.allEmployees = allEmployees; }
	 */
}
