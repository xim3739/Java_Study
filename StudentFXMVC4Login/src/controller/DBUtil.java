package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/studentDB";

	public static Connection getConnection() throws Exception {

		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, "root", "1234");

		return connection;

	}
}
