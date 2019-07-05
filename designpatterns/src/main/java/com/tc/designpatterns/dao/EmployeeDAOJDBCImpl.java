package com.tc.designpatterns.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tc.designpatterns.beans.EmployeeInfoBean;

import lombok.extern.java.Log;

@Log
public final class EmployeeDAOJDBCImpl implements EmployeeDao {

	public ArrayList<EmployeeInfoBean> getAllEmployeeInfo() {
		String dbUrl = "jdbc:mysql://localhost:3306/techchefs_db";
		String query = "select * from employee_info";
		try (Connection conn = DriverManager.getConnection(dbUrl, "root", "root");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			log.info("Connection Impl Class ======>" + conn.getClass());
			ArrayList<EmployeeInfoBean> beans = new ArrayList<EmployeeInfoBean>();
			while (rs.next()) {
				EmployeeInfoBean bean = new EmployeeInfoBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setAge(rs.getInt("age"));
				bean.setGender(rs.getString("gender"));
				bean.setSalary(rs.getDouble("salary"));
				bean.setPhone(rs.getLong("phone"));
				bean.setJoiningDate(rs.getDate("joining_date"));
				bean.setAccountNumber(rs.getLong("account_number"));
				bean.setEmail(rs.getString("email"));
				bean.setDesignation(rs.getString("designation"));
				bean.setDob(rs.getDate("dob"));
				bean.setDepartmentId(rs.getInt("dept_id"));
				bean.setManagerId(rs.getInt("mngr_id"));
				beans.add(bean);// Adding a bean record to Arraylist
			}
			return beans;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public EmployeeInfoBean getEmployeeInfo(String id) {
		try {
			return getEmployeeInfo(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}

	}

	public EmployeeInfoBean getEmployeeInfo(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String dbUrl = "jdbc:mysql://localhost:3306/techchefs_db";
			conn = DriverManager.getConnection(dbUrl, "root", "root");
			log.info("Connection Impl Class ======>" + conn.getClass());
			String query = "select * from employee_info" + " where id=?";
			System.out.println(query);
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			EmployeeInfoBean bean = new EmployeeInfoBean();
			while (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setAge(rs.getInt("age"));
				bean.setGender(rs.getString("gender"));
				bean.setSalary(rs.getDouble("salary"));
				bean.setPhone(rs.getLong("phone"));
				bean.setJoiningDate(rs.getDate("joining_date"));
				bean.setAccountNumber(rs.getLong("account_number"));
				bean.setEmail(rs.getString("email"));
				bean.setDesignation(rs.getString("designation"));
				bean.setDob(rs.getDate("dob"));
				bean.setDepartmentId(rs.getInt("dept_id"));
				bean.setManagerId(rs.getInt("mngr_id"));
			}
			return bean;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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
				e.printStackTrace();
			}
		}

	}

//END of getEmployeeInfo(int) method

}
