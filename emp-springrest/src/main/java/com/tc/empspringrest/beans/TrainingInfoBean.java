package com.tc.empspringrest.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "training_info")
//@XmlRootElement(name = "training-info")
//@XmlAccessorType(XmlAccessType.FIELD)
public class TrainingInfoBean implements Serializable {
	@Id
	@Column(name = "course_id")
//	@XmlElement(name = "course-id")
	private int courseId;
	@Column(name = "course_name")
//	@XmlElement(name = "course-name")
	private String courseName;
	@Column(name = "duration")
	private String duration;
	@Column(name = "course_type")
//	@XmlElement(name = "course-type")
	private String courseType;

//	@XmlTransient
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "employee_traininginfo", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = {
			@JoinColumn(name = "id") })
	private List<EmployeeInfoBean> infoBeans;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public List<EmployeeInfoBean> getInfoBeans() {
		return infoBeans;
	}

	public void setInfoBeans(List<EmployeeInfoBean> infoBeans) {
		this.infoBeans = infoBeans;
	}

}
