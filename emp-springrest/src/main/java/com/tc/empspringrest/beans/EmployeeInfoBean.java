package com.tc.empspringrest.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@SuppressWarnings("serial")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@XmlRootElement(name = "employee-info")
//@XmlAccessorType(XmlAccessType.FIELD)
@Data
@JsonRootName(value = "employeeInfo")
@Entity
@Table(name = "employee_info")
public class EmployeeInfoBean implements Serializable {

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "infoBean")
//	@XmlElement(name = "other-info")
	@JsonProperty(value = "otherInfo")
	private EmployeeOtherInfoBean otherInfo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "addressPKBean.infoBean")
	@LazyCollection(LazyCollectionOption.FALSE)
//	@XmlElement(name = "address-info-beans")
	@JsonProperty(value = "addressInfoBeans")
	private List<EmployeeAddressInfoBean> addressInfoBeans;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "experiencePKBean.infoBean")
	@LazyCollection(LazyCollectionOption.FALSE)
//	@XmlElement(name = "experience-info-beans")
	@JsonProperty(value = "experienceInfoBeans")
	private List<EmployeeExperienceInfoBean> experienceInfoBeans;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "educationPKBean.infoBean")
	@LazyCollection(LazyCollectionOption.FALSE)
//	@XmlElement(name = "education-info-beans")
	@JsonProperty(value = "educationInfoBeans")
	private List<EmployeeEducationInfoBean> educationInfoBeans;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "infoBeans")
	@LazyCollection(LazyCollectionOption.FALSE)
//	@XmlElement(name = "training-info-beans")
	@JsonProperty(value = "trainingInfoBeans")
	private List<TrainingInfoBean> trainingInfoBeans;

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "gender")
	private String gender;
	@Column(name = "salary")
	private double salary;
	@Column(name = "phone")
	private long phone;
	@Column(name = "joining_date")
//	@XmlElement(name = "joining-date")
	private Date joiningDate;
	@Column(name = "account_number")
//	@XmlElement(name = "account-number")
	@JsonProperty(value = "accountNumber")
	private long accountNumber;
	@Column(name = "email")
	private String email;
	@Column(name = "designation")
	private String designation;
	@Column(name = "dob")
	private Date dob;
	@Column(name = "password")
	private String password;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "department_id", referencedColumnName = "dept_id")
	private DepartmentInfoBean deptInfoBean;

//	@Column(name = "dept_id")
//	@XmlElement(name = "department-id")
//	private int departmentId;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "mngr_id", referencedColumnName = "id")
	private EmployeeInfoBean mngrId;

}
