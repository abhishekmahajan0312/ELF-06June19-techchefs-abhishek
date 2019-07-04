package com.tc.jdbc.beans;

import lombok.Data;

@Data
public class EmployeeAddressInfoBean {
	int id;
	String addressType;
	String address1;
	String address2;
	String landmark;
	String city;
	String state;
	String country;
	int pin;
}
