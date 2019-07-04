package com.tc.jdbcapp2;

public class MainMethodClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ref = DriverManager.getConnection(args[0]);
		ref.m();
	}
}
