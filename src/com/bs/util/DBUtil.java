package com.bs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class DBUtil {
	static Connection connection;

	public static Connection getConnection() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("oracle");
		String url = resourceBundle.getString("db.url");
		String username = resourceBundle.getString("db.username");
		String password = resourceBundle.getString("db.password");

		try {
			Class.forName(resourceBundle.getString("db.driver"));
			connection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
