package com.techchefs.edulib.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "user")

public class User implements Serializable {

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<UserFine> userFines;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "user_type")
	private String userType;
	@Column(name = "phone")
	private long phone;
	@Column(name = "email")
	private String email;
	@Column(name = "current_address")
	private String currentAddress;
	@Column(name = "image")
	private String image;
}
