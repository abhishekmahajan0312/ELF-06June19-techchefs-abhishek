package com.tc.jdbc.connectionpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.java.Log;

@Log
public final class ConnectionPoolTest {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {

			pool = ConnectionPool.getConnectionPool();
			con = pool.getConnectionFromPool();
			log.info("Connection Impl Class ======>" + con.getClass());
			String query = "select * from employee_info where id=1";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				log.info("ID=" + rs.getString(2));
				System.out.println("ID=" + rs.getString("Name"));
//			logger.
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				pool.returnConnectionToPool(con);

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
