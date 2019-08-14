package com.tc.empspringrest.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.val;

@Entity
//@XmlRootElement(name="employee-other-info-bean")
//@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "employee_otherinfo")
public class EmployeeOtherInfoBean implements Serializable{
	@Id
	@OneToOne
	@JoinColumn(name = "id" )
//	@XmlTransient
	@JsonIgnore
	private EmployeeInfoBean infoBean;
	
	@Column(name = "pan")
	private String pan;
//	@XmlElement(name = "is-married")
	@JsonProperty(value = "is-married")
	@Column(name = "ismarried")
	private Boolean isMarried;
	@Column(name = "blood_grp")
	@JsonProperty(value = "blood-group")
//	@XmlElement(name = "blood-group")
	private String bloodGrp;
	@Column(name = "ischallenged")
//	@XmlElement(name = "is-challenged")
	@JsonProperty(value= "is-challenged")
	private Boolean isChallenged;
	@Column(name = "emergency_contact_number")
//	@XmlElement(name = "emergency-contact-number")
	@JsonProperty(value = "emergency-contact-number")
	private long emergencyCN;
//	@XmlElement(name = "emergency-contact-person")
	@JsonProperty(value = "emergency-contact-person")
	@Column(name = "emergency_contact_person")
	private String emergencyCP;
	@Column(name = "nationality")
	private String nationality;
	@Column(name = "religion")
	private String religion;
	@Column(name = "father_nm")
//	@XmlElement(name = "father-name")
	@JsonProperty(value = "father-name")
	private String fatherNM;
	@Column(name = "mother_nm")
//	@XmlElement(name = "mother-name")
	@JsonProperty(value = "mother-name")
	private String motherNM;
	@Column(name = "spouse_nm")
//	@XmlElement(name = "spouse-name")
	@JsonProperty(value = "spouse-name")
	private String spouseNM;
	@Column(name = "passport")
	private String passport;
	@Column(name = "adhar")
	private long adhar;
	public EmployeeInfoBean getInfoBean() {
		return infoBean;
	}
	public void setInfoBean(EmployeeInfoBean infoBean) {
		this.infoBean = infoBean;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	public String getBloodGrp() {
		return bloodGrp;
	}
	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}
	public boolean isChallenged() {
		return isChallenged;
	}
	public void setChallenged(boolean isChallenged) {
		this.isChallenged = isChallenged;
	}
	public long getEmergencyCN() {
		return emergencyCN;
	}
	public void setEmergencyCN(long emergencyCN) {
		this.emergencyCN = emergencyCN;
	}
	public String getEmergencyCP() {
		return emergencyCP;
	}
	public void setEmergencyCP(String emergencyCP) {
		this.emergencyCP = emergencyCP;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getFatherNM() {
		return fatherNM;
	}
	public void setFatherNM(String fatherNM) {
		this.fatherNM = fatherNM;
	}
	public String getMotherNM() {
		return motherNM;
	}
	public void setMotherNM(String motherNM) {
		this.motherNM = motherNM;
	}
	public String getSpouseNM() {
		return spouseNM;
	}
	public void setSpouseNM(String spouseNM) {
		this.spouseNM = spouseNM;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public long getAdhar() {
		return adhar;
	}
	public void setAdhar(long adhar) {
		this.adhar = adhar;
	}
	
	
}
