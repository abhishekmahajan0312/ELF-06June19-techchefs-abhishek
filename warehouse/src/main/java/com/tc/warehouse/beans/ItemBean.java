package com.tc.warehouse.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "items")
public class ItemBean implements Serializable{
	@Id
	@Column(name = "item_id")
	private int itemID;
	@Column(name = "item_name")
	private String name;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "description")
	private String description;
	@Column(name = "cost")
	private float cost;
}
