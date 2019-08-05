package com.tc.hibernatemapping.bean.manytoone;

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

import com.tc.hibernatemapping.bean.primary.EmployeeInfoBean;

import lombok.Data;

@Data
@Entity
@Table(name = "training_info")
public class TrainingInfoBean implements Serializable {
	@Id
	@Column(name="course_id")
	private int courseId;
	@Column(name = "course_name")
	private String courseName;
	@Column(name = "duration")
	private String duration;
	@Column(name = "course_type")
	private String courseType;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_traininginfo",
				joinColumns = {@JoinColumn(name="course_id")},
				inverseJoinColumns = {@JoinColumn(name="id")})
	private List<EmployeeInfoBean> infoBeans;
}
