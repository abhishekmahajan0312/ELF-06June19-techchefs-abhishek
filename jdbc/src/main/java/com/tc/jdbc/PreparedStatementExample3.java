package com.tc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.java.Log;

@Log
public final class PreparedStatementExample3 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
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
			String dbUrl = "jdbc:mysql://localhost:3306/techchefs_db";
//		conn = DriverManager.getConnection(dbUrl);
			conn = DriverManager.getConnection(dbUrl, "root", "root");
			log.info("Connection Impl Class ======>"+conn.getClass());
			String query = "insert into employee_info"
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
//			String query = "create database test2";
			stmt = conn.prepareStatement(query);
			for(int i=0;i<13;i++) {
			System.out.println(args[i]);
			}
			stmt.setInt(1, Integer.parseInt(args[0]));
			
			stmt.setString(2, args[1]);
			stmt.setInt(3, Integer.parseInt(args[2]));
			stmt.setString(4, args[3]);
			stmt.setDouble(5, Double.parseDouble(args[4]));
			stmt.setLong(6, Long.parseLong(args[5]));
			stmt.setString(7, args[6]);
			stmt.setLong(8, Long.parseLong(args[7]));
			stmt.setString(9, args[8]);
			stmt.setString(10,args[9]);
			stmt.setString(11, args[10]);
			stmt.setInt(12, Integer.parseInt(args[11]));
			stmt.setInt(13, Integer.parseInt(args[12]));
			int count = stmt.executeUpdate();
			log.info(count+"");
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
