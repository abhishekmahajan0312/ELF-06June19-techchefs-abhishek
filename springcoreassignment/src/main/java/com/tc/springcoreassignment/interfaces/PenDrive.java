package com.tc.springcoreassignment.interfaces;

import lombok.Data;
import lombok.extern.java.Log;

@Data
@Log
public class PenDrive implements StorageDevice {

	String capacity;
	String readingSpeed;
	String writingSpeed;
	public void write() {
		log.info("PD Write Speed"+writingSpeed);
	}

	public void read() {
		log.info("PD Read Speed"+readingSpeed);
	}

	public void format() {
		log.info("PD Format Capacity"+capacity);
	}
}
