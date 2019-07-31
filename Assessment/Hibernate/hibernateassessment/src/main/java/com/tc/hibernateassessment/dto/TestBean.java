package com.tc.hibernateassessment.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "test")
public class TestBean implements Serializable{
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "firstname")
	private String fName;
	@Column(name = "lastname")
	private String lName;
	@Column(name = "city")
	private String city;
}
