package com.techchefs.edulib.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "user_fine")
public class UserFine implements Serializable {

	@Id
	@Column(name = "fine_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer fineId;
	@ManyToOne
	@JoinColumn(name = "user_id",referencedColumnName = "id")
	private User userId;
	@Column(name = "fine")
	private double fine;
	@Column(name = "fine_description")
	private String fineDescription;
	@Column(name = "payment_status")
	private String paymentStatus;
}
