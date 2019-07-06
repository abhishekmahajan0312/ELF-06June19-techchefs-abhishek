package com.tc.designpatterns;

import lombok.extern.java.Log;

@Log
public class MyImmutableClassTest {

	public static void main(String[] args) {
		MyImmutableClass immutableClass = null;
		immutableClass = new MyImmutableClass("ABC", 16, 9876543210L);
		log.info("Name: " + immutableClass.getName());
		log.info("Age: " + immutableClass.getAge());
		log.info("Phone: " + immutableClass.getPhone());

		immutableClass = new MyImmutableClass("XYZ", 16, 11445566998L);
		log.info("Name: " + immutableClass.getName());
		log.info("Age: " + immutableClass.getAge());
		log.info("Phone: " + immutableClass.getPhone());

	}// End of main
}// End of Class
