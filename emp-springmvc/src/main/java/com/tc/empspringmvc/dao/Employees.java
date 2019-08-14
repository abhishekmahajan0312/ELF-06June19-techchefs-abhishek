package com.tc.empspringmvc.dao;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.tc.empspringmvc.beans.EmployeeInfoBean;

import lombok.Data;

@XmlRootElement(name = "employees")
@Data
public class Employees {
	private List<EmployeeInfoBean> allEmployees;
}
