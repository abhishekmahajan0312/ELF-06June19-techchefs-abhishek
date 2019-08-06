package com.tc.hibernateassessment.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "student_info")
public class StudentInfoBean implements Serializable{
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	StudentOtherInfoBean otherInfo;
	
	@Id
	@Column(name = "rollnum")
	private int rollNum;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "gender")
	private String gender;
	@Column(name = "mobileno")
	private long mobileNo;
	@Column(name = "emailid")
	private String emailId;
}
