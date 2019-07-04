package com.tc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.java.Log;

@Log
public final class PreparedStatementExample1 {

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
			String query = "select * from employee_info"
					+ " where id=?";
			System.out.println(query);
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, Integer.parseInt(args[0]));
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				log.info("ID=" + rs.getString("Name"));
				System.out.println("ID=" + rs.getString("Name"));
//			logger.
			}

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
