package com.tc.springboot.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.val;

@Entity
//@XmlRootElement(name="employee-other-info-bean")
//@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "employee_otherinfo")
@Data
public class EmployeeOtherInfoBean implements Serializable{
	@Id
	@GeneratedValue
	@JsonIgnore
	private int otherInfoid;
	
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id", unique = true, nullable =false)
//	@XmlTransient
	@JsonIgnore
	private EmployeeInfoBean infoBean;
	
	@Column(name = "pan")
	private String pan;
//	@XmlElement(name = "is-married")
	@Column(name = "ismarried")
	private Boolean isMarried;
	@Column(name = "blood_grp")
	
//	@XmlElement(name = "blood-group")
	private String bloodGrp;
	@Column(name = "ischallenged")
//	@XmlElement(name = "is-challenged")
	private Boolean isChallenged;
	@Column(name = "emergency_contact_number")
//	@XmlElement(name = "emergency-contact-number")
	private long emergencyCN;
//	@XmlElement(name = "emergency-contact-person")
	@Column(name = "emergency_contact_person")
	private String emergencyCP;
	@Column(name = "nationality")
	private String nationality;
	@Column(name = "religion")
	private String religion;
	@Column(name = "father_nm")
//	@XmlElement(name = "father-name")
	private String fatherNM;
	@Column(name = "mother_nm")
//	@XmlElement(name = "mother-name")
	private String motherNM;
	@Column(name = "spouse_nm")
//	@XmlElement(name = "spouse-name")
	private String spouseNM;
	@Column(name = "passport")
	private String passport;
	@Column(name = "adhar")
	private long adhar;
	
}
