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
public class EmployeeEducationPKBean implements Serializable{

	@JoinColumn(name = "id")
	@ManyToOne
	private EmployeeInfoBean infoBean;
	@Column(name = "educational_type")
	private String educationalType;
}
