package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {

	// ���� ���� ����Ǿ���� ����޼ҵ�
	public static Connection connec() throws Exception {
		Connection con = null;
		String id = "scott";
		String pw = "targer";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		try {
			// ����̹�
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			System.err.println("����̹� ����" + e);
		} catch (Exception e) {
			System.err.println("�������" + e);
		}

		return con;

	}

}