package com.tc.hibernateassessment.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class ProductsBean implements Serializable{
	@Id
	@Column(name = "productid")
	private int id;
	@Column(name = "productname")
	private String productName;
	@Column(name = "price")
	private double price;
	@Column(name = "colour")
	private String colour;
	@Column(name = "weight")
	private double weight;
}
