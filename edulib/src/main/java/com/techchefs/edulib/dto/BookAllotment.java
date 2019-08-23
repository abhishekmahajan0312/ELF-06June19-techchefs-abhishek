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

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "book_allotment")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")

public class BookAllotment implements Serializable {

	@Id
	@Column(name = "book_allotment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookAllotmentId;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User userId;
	@ManyToOne
	@JoinColumn(name = "book_id",referencedColumnName = "id")
	private Book bookId;
	@Column(name = "issue_date")
	private Date issueDate;
	@Column(name = "return_date")
	private Date returnDate;
	@Column(name = "return_status")
	private int returnStatus;
}
