package com.tc.hibernateApp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "emp_info")
public class EmployeeNewInfoBean implements Serializable {
	@Id
	@Column(name = "eid")
	private int eid;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
}
