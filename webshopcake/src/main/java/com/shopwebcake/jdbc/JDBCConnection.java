package com.shopwebcake.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	// public static Connection getJDBCConnection() {

	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	// String url = "jdbc:mysql://localhost:3306/webshop";
	// String user = "root";
	// String password = "Ginbe970901";
	// return DriverManager.getConnection(url, user, password);
	// } catch (ClassNotFoundException | SQLException e) {

	// return null;
	// }
	// }

	public static Connection getJDBCConnection() {

		try {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=ShopCake;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
			return DriverManager.getConnection(connectionURL, "sa", "123");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
