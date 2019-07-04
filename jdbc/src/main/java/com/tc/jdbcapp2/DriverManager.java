package com.tc.jdbcapp2;

public class DriverManager {
	private DriverManager() {
		
	}
	public static Connection getConnection(String str) {
		Connection ref;
		if(str.equals("one")) {
			ref = new A();
		}
		else {
			ref = new B();
		}
		return ref;
	}
}
