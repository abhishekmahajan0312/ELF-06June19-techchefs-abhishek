package com.tc.jdbc.connectionpool;

import static com.tc.jdbc.connectionpool.ConnectionPoolConstants.DB_URL;
import static com.tc.jdbc.connectionpool.ConnectionPoolConstants.DRIVER_CLASS_NAME;
import static com.tc.jdbc.connectionpool.ConnectionPoolConstants.PASSWORD;
import static com.tc.jdbc.connectionpool.ConnectionPoolConstants.POOL_SIZE;
import static com.tc.jdbc.connectionpool.ConnectionPoolConstants.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPool {
	private Vector<Connection> pool = new Vector<>();
	private int poolsize;
//	Properties properties;
	private String dbUrl;
	private String userNM;
	private String password;
	private String driverClassNM;
	private Connection con = null;
	private static ConnectionPool poolRef = null;
	PropertiesUtil util = null;

	private ConnectionPool() throws Exception {
		loadValues();
		createPool();

	}

	private void loadValues() throws Exception {
//		FileInputStream fis = new FileInputStream("jdbcprop.properties");
//		properties = new Properties();
//		properties.load(fis);
//		Class.forName(properties.getProperty("drivername"));
		util = PropertiesUtil.getPropertiesUtil();
		dbUrl = util.getProperty(DB_URL);
		userNM = util.getProperty(USERNAME);
		password = util.getProperty(PASSWORD);
		poolsize = Integer.parseInt(util.getProperty(POOL_SIZE));
		driverClassNM = util.getProperty(DRIVER_CLASS_NAME);
	}

	private void createPool() throws Exception {
		Class.forName(driverClassNM);
		for (int i = 0; i < poolsize; i++) {
			con = DriverManager.getConnection(dbUrl, userNM, password);
			pool.add(con);
		}
	}

	public static ConnectionPool getConnectionPool() throws Exception {
		if (poolRef == null) {
			poolRef = new ConnectionPool();
		}
		return poolRef;
	}

	public Connection getConnectionFromPool() {
		return pool.remove(0);
	}

	public void returnConnectionToPool(Connection con) {
		pool.add(con);
	}
}
