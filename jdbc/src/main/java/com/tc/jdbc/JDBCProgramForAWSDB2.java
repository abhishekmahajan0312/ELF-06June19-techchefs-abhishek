package com.tc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.java.Log;

@Log
public final class JDBCProgramForAWSDB2 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
//		Driver driver = new com.mysql.jdbc.Driver();
//		DriverManager.registerDriver(driver);
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String dbUrl = "jdbc:mysql://techchefs-db-instance.ciiufzrs6rkx.ap-south-1.rds.amazonaws.com/techchefs_db_rds";
//		conn = DriverManager.getConnection(dbUrl);
			conn = DriverManager.getConnection(dbUrl, "root", "rootroot");
			log.info("Connection Impl Class ======>" + conn.getClass());
			String query = "insert into employee_info"
					+ " values(16,'Rakesh',34,'Male',100000,9876543210,'2019-02-02',12345678901,'rakesh@gmail.com','Software Developer','2000-02-01',2,3)";
//			String query = "create database test2";
			stmt = conn.createStatement();
			int count = stmt.executeUpdate(query);
			log.info(count + "");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {

					stmt.close();

				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
