package com.tc.empspringrest.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
@SuppressWarnings("serial")
@Data
@Embeddable
public class EmployeeAddressPKBean implements Serializable{

	@JoinColumn(name = "id")
	@ManyToOne
	private EmployeeInfoBean infoBean;
	@Column(name = "address_type")
	private String addressType;
	
	
}
