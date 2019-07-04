package com.tc.jdbc.connectionpool;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static PropertiesUtil propertiesUtil = null;
	Properties properties = null;

	private PropertiesUtil() throws Exception {
		properties = new Properties();
		properties.load(new FileInputStream("jdbcprop.properties"));
	}

	public static PropertiesUtil getPropertiesUtil() throws Exception {
		if (propertiesUtil == null) {
			propertiesUtil = new PropertiesUtil();
		}
		return propertiesUtil;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
