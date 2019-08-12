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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@SuppressWarnings("serial")
@XmlRootElement(name = "employee-info-bean")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "employee_info")
public class EmployeeInfoBean implements Serializable {

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "infoBean")
	@XmlElement(name = "other-info")
	private EmployeeOtherInfoBean otherInfo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "addressPKBean.infoBean")
	@LazyCollection(LazyCollectionOption.FALSE)
	@XmlElement(name = "address-info-beans")
	private List<EmployeeAddressInfoBean> addressInfoBeans;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "experiencePKBean.infoBean")
	@LazyCollection(LazyCollectionOption.FALSE)
	@XmlElement(name = "experience-info-beans")
	private List<EmployeeExperienceInfoBean> experienceInfoBeans;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "educationPKBean.infoBean")
	@LazyCollection(LazyCollectionOption.FALSE)
	@XmlElement(name = "education-info-beans")
	private List<EmployeeEducationInfoBean> educationInfoBeans;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "infoBeans")
	@LazyCollection(LazyCollectionOption.FALSE)
	@XmlElement(name = "training-info-beans")
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
	@XmlElement(name = "joining-date")
	private Date joiningDate;
	@Column(name = "account_number")
	@XmlElement(name = "account-number")
	private long accountNumber;
	@Column(name = "email")
	private String email;
	@Column(name = "designation")
	private String designation;
	@Column(name = "dob")
	private Date dob;
	@Column(name = "password")
	private String password;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id", referencedColumnName = "dept_id")
	private DepartmentInfoBean deptInfoBean;
	
//	@Column(name = "dept_id")
//	@XmlElement(name = "department-id")
//	private int departmentId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "mngr_id", referencedColumnName = "id")
	private EmployeeInfoBean mngrId;
	
	
	public EmployeeOtherInfoBean getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(EmployeeOtherInfoBean otherInfo) {
		this.otherInfo = otherInfo;
	}

	public List<EmployeeAddressInfoBean> getAddressInfoBeans() {
		return addressInfoBeans;
	}

	public void setAddressInfoBeans(List<EmployeeAddressInfoBean> addressInfoBeans) {
		this.addressInfoBeans = addressInfoBeans;
	}

	public List<EmployeeExperienceInfoBean> getExperienceInfoBeans() {
		return experienceInfoBeans;
	}

	public void setExperienceInfoBeans(List<EmployeeExperienceInfoBean> experienceInfoBeans) {
		this.experienceInfoBeans = experienceInfoBeans;
	}

	public List<EmployeeEducationInfoBean> getEducationInfoBeans() {
		return educationInfoBeans;
	}

	public void setEducationInfoBeans(List<EmployeeEducationInfoBean> educationInfoBeans) {
		this.educationInfoBeans = educationInfoBeans;
	}

	public List<TrainingInfoBean> getTrainingInfoBeans() {
		return trainingInfoBeans;
	}

	public void setTrainingInfoBeans(List<TrainingInfoBean> trainingInfoBeans) {
		this.trainingInfoBeans = trainingInfoBeans;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	
	public DepartmentInfoBean getDeptInfoBean() {
		return deptInfoBean;
	}

	public void setDeptInfoBean(DepartmentInfoBean deptInfoBean) {
		this.deptInfoBean = deptInfoBean;
	}

	public EmployeeInfoBean getMngrId() {
		return mngrId;
	}

	public void setMngrId(EmployeeInfoBean mngrId) {
		this.mngrId = mngrId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
