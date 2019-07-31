package com.tc.hibernateassessment.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "student")
public class StudentBean implements Serializable{
	@Id
	@Column(name = "rollnum")
	private int rollNum;
	@Column(name = "firstname")
	private String fName;
	@Column(name = "lastname")
	private String lName;
	@Column(name = "subject")
	private String subject;
	@Column(name = "totalmarks")
	private double totalMarks;
}
