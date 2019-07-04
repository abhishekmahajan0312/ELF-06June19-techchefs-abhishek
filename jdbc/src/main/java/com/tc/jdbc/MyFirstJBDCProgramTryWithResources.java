package com.tc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.java.Log;

@Log
public final class MyFirstJBDCProgramTryWithResources {

	public static void main(String[] args) {
		String dbUrl = "jdbc:mysql://localhost:3306/techchefs_db";
		String query = "select * from employee_info where id=1";
		try(Connection conn = DriverManager.getConnection(dbUrl, "root", "root"); 
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {
//		Driver driver = new com.mysql.jdbc.Driver();
//		DriverManager.registerDriver(driver);
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//		conn = DriverManager.getConnection(dbUrl);
//			conn = DriverManager.getConnection(dbUrl, "root", "root");
			log.info("Connection Impl Class ======>"+conn.getClass());
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);
			while (rs.next()) {
				log.info("ID=" + rs.getString(2));
				System.out.println("ID=" + rs.getString("Name"));
//			logger.
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

//		finally {
//			try {
//				if (conn != null) {
//					conn.close();
//				}
//				if (stmt != null) {
//
//					stmt.close();
//
//				}
//				if (rs != null) {
//					rs.close();
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}

}
