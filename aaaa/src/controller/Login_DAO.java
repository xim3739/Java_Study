package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Login_VO;

public class Login_DAO {

	// ���̵� ��й�ȣ ��� �޼ҵ�
	public Login_VO login_input(Login_VO loginvo) throws Exception {
		// 1.VO�� �� ��ȯ������ �޾ƿ��°� ��������

		// 2.SQL�� �ۼ�
		StringBuffer sql = new StringBuffer(); // String ��� StringBuffer���
		sql.append("insert into test_login (id, pw) " + "values (?, ?)");

		// 3.3������ ����(con,ps,rs-resultSet��� VO��(�����Ͱ� ���ִ� list)���� ��ü)
		Connection con = null;
		PreparedStatement ps = null;
		Login_VO lvo = loginvo; //null���� �ƴ� �Ű������� �޾Ҵ� �� �ִ´�.
		
		//������ ���� try-catch�� ���
		try {
			//DButil Ŭ������ ����޼ҵ�� �������
			con = DButil.connec();
			
			//preparedStatement con�� �����Ŵ
			ps = con.prepareStatement(sql.toString());
			
			//preparedStatements�� SQL�� ����
			ps.setString(1, lvo.getId()); //ps.set��ȯ��(���°,VOŬ���� ����.get������ �׸�)
			ps.setString(2, lvo.getPw());
			
			//SQL�� ���� �� ó�� ���
			int i = ps.executeUpdate(); //update���� �����ϸ� 1�� ����
			
			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("�߰�");
				alert.setHeaderText("�߰�����");
				alert.setContentText("SQL developer���� Ȯ���غ��ÿ�");

				alert.showAndWait();

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("�߰�");
				alert.setHeaderText("�߰�����");
				alert.setContentText("������ã���ÿ�");

				alert.showAndWait();
			}
		
		} catch (SQLException e) {
			// SQL�� ����
			System.err.println("SQL�� ���� "+e);
		} catch (Exception e) {
			// �׿� �ٸ� ����
			System.err.println("���� "+e);
		} finally {
			try {
				//���������������� �ݴ´�.
				if (ps != null) // ������ ������ (null���� �ƴҶ�) �ݴ´�.
					ps.close();
				if (con != null) // ������ ������ (null���� �ƴҶ�) �ݴ´�.
					con.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return loginvo;
	}
}
