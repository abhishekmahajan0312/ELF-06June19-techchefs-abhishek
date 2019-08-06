package com.tc.hibernateassessment.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "customer")
public class CustomerBean implements Serializable{
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "firstname")
	private String fName;
	@Column(name = "lastname")
	private String lName;
	@Column(name = "contactnumber")
	private long contactNumber;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "country")
	private String country;
}
