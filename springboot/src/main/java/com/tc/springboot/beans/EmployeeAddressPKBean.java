package com.tc.springboot.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@SuppressWarnings("serial")
//@XmlRootElement(name = "employee-address-pk")
//@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
@Data
public class EmployeeAddressPKBean implements Serializable {
	
//	@XmlTransient
	@JsonIgnore
	@JoinColumn(name = "id")
	@ManyToOne
	private EmployeeInfoBean infoBean;
	@Column(name = "address_type")
//	@XmlElement(name="address-type")
//	@JsonProperty(value="address-type")
	private String addressType;
}
