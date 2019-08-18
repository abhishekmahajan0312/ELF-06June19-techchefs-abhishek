package com.tc.springboot.beans;

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
@Data
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
	@JoinTable(name = "employee_traininginfo", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = { @JoinColumn(name = "id") })
	private List<EmployeeInfoBean> infoBeans;

	
}
