package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getConnection() {

		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/egatepass";
			String userName = "root";
			String password = "root";
			// 1 - load driver
			Class.forName(driver);
			// 2 connection
			Connection con = DriverManager.getConnection(url, userName, password);
			return con;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
