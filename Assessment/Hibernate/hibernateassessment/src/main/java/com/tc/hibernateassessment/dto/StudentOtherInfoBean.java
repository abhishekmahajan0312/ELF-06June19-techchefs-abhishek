package com.tc.hibernateassessment.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "student_otherinfo")
public class StudentOtherInfoBean implements Serializable{
	@Id
	@Column(name = "rollnum")
	private int rollNum;
	@Column(name = "fathername")
	private String fatherNM;
	@Column(name = "mothername")
	private String motherNM;
	@Column(name = "religion")
	private String religion;
	@Column(name = "nationality")
	private String nationality;
}
