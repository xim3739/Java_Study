package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {

	// 가장 먼저 실행되어야할 연결메소드
	public static Connection connec() throws Exception {
		Connection con = null;
		String id = "scott";
		String pw = "targer";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		try {
			// 드라이버
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 실패" + e);
		} catch (Exception e) {
			System.err.println("연결실패" + e);
		}

		return con;

	}

}