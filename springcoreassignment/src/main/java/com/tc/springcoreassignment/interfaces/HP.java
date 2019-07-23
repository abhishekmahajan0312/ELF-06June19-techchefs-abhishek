package com.tc.springcoreassignment.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Data;
import lombok.extern.java.Log;

@Data
@Log
public class HP implements Laptop {

	private String brand;
	private String color;
	private float cost;
	private String weight;
	private String ram;
	private String os;
	
	@Autowired
	@Qualifier("")
	StorageDevice storageDevice;
	
	public void display() {
		log.info("Displaying HP Laptop");
	}

	public void process() {
		log.info("Processing HP Laptop");
	}

	public void showSpecification() {
		log.info("Showing HP Configuration");
		log.info("Brand:"+brand);
		log.info("Color:"+color);
		log.info("Cost:"+cost);
		log.info("Weight:"+weight);
		log.info("RAM:"+ram);
		log.info("OS:"+os);
		storageDevice.write();
		storageDevice.read();
		storageDevice.format();
	}

}
