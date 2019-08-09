package com.tc.empspringrest.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="department_info")
@Data
public class DepartmentInfoBean implements Serializable {

	@Id
	@Column(name="dept_id")
	private int departmentId;
	
	@Column(name="dept_name")
	private String departmentName;
}
