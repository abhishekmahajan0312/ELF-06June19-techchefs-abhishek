package com.tc.springcoreassignment.interfaces;

import lombok.Data;
import lombok.extern.java.Log;

@Data
@Log
public class HardDisk implements StorageDevice {

	String capacity;
	String readingSpeed;
	String writingSpeed;
	public void write() {
		log.info("HD Write Speed"+writingSpeed);
	}

	public void read() {
		log.info("HD Read Speed"+readingSpeed);
	}

	public void format() {
		log.info("HD Format Capacity"+capacity);
	}

}
