package com.techchefs.edulib.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "book")
public class Book implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	@Column(name = "name")
	private String bookName;
	@Column(name = "isbn")
	private String isbn;
	@Column(name = "author")
	private String author;
	@Column(name = "category")
	private String category;
	@Column(name = "price")
	private double price;
	@Column(name = "count")
	private int count;
	@Column(name = "image")
	private String image;
}
