package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Product_VO;

public class Product_DAO {

	// ��ǰ�Է¸޼ҵ�
	public Product_VO input_pro(Product_VO pvo) throws Exception {

		StringBuffer sql = new StringBuffer();
		sql.append("insert into test_product values (?,?,?,?)");

		Connection con = null;
		PreparedStatement ps = null;
		Product_VO vo = pvo;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, vo.getPro_no());
			ps.setString(2, vo.getPro_name());
			ps.setInt(3, vo.getPro_price());
			ps.setInt(4, vo.getPro_num());

			int i = ps.executeUpdate();

			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("��ǰ���");
				alert.setHeaderText("'" + vo.getPro_name() + "' ��ǰ����� �Ǿ����ϴ�.");
				alert.setContentText("��ǰ��� ����");
				alert.showAndWait();
			}

		} catch (SQLException e) {
			System.out.println("SQL�� ����:" + e);

		} catch (Exception e) {
			System.out.println("SQL�� ����:" + e);
		} finally {
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
		return pvo;
	}

	// ��ǰ�ڵ��ȣ ����Ʈ �� ��������
	// ArrayList�� �ް� ������ voŬ����
	public ArrayList<Product_VO> get_list_proNo() {
		ArrayList<Product_VO> list = new ArrayList<Product_VO>();
		StringBuffer sql = new StringBuffer();
		sql.append("select pro_no from test_product"); // SQL���ۼ�

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product_VO vo = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();

			// while�� ����Ͽ� resultSet�� ����� sql�� ��������

			while (rs.next()) { // rs������ �ֳľ��Ŀ� ���� �ݺ���
				vo = new Product_VO();// �ν��Ͻ�
				vo.setPro_no(rs.getString(1)); // voŬ������ �����Ѵ�. �������� rs�� ù��° �ε���
												// ��
				list.add(vo); // vo�� ����� ���� list�� ������.
			}
		} catch (SQLException e) {
			System.err.println("SQL�� ����" + e);
		} catch (Exception e) {
			System.err.println("����" + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return list;
	}

	// ��ǰ ��ü����Ʈ
	// ArrayList�� �ް� ������(��ȯ��)�� voŬ����
	public ArrayList<Product_VO> get_pro() {
		ArrayList<Product_VO> list = new ArrayList<Product_VO>();

		StringBuffer sql = new StringBuffer();
		sql.append("select pro_no, pro_name, pro_price " + "from test_product order by pro_no");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product_VO vo = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new Product_VO();
				vo.setPro_no(rs.getString(1));
				vo.setPro_name(rs.getString(2));
				vo.setPro_price(rs.getInt(3));
				list.add(vo);
			}
		} catch (SQLException e) {
			System.err.println("SQL������=" + e);
		} catch (Exception e) {
			System.err.println("����=" + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return list;

	}

	// �����ͺ��̽����� ��ǰ���̺��� ��ǰ����
	// ArrayList�� �ް� ������(��ȯ��)�� String
	public ArrayList<String> get_Column_num() {
		ArrayList<String> num = new ArrayList<String>();

		StringBuffer sql = new StringBuffer();
		sql.append("select pro_no, pro_name, pro_price " + "from test_product");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product_VO vo = null;
		// resultSetMetaData ��������
		ResultSetMetaData rsmd = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();

			// Į������
			int col = rsmd.getColumnCount(); // Į��ī���� ������ col�� ����

			for (int i = 1; i <= col; i++) {
				num.add(rsmd.getColumnName(i)); // Į���̸��߰�??
			}
		} catch (SQLException e) {
			System.err.println("SQL������=" + e);
		} catch (Exception e) {
			System.err.println("����=" + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return num;
	}

	// �����޼ҵ�
	public void get_delete(String pro_no) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from test_product where pro_no = ?");

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, pro_no);

			// �����
			int i = ps.executeUpdate();
			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("��ǰ���� ����");
				alert.setHeaderText("'"+pro_no+"' ��ǰ����");
				alert.setContentText("������ ��ǰ�� ��������Ǿ����ϴ�.");
				alert.showAndWait();
			}

		} catch (SQLException e) {
			System.out.println("SQL����:" + e);
		} catch (Exception e) {
			System.out.println("SQL����:" + e);

		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}

	// ��ȸ �˻�
	public ObservableList<Product_VO> get_select(String pro_no) throws Exception {
		ObservableList<Product_VO> list = FXCollections.observableArrayList();
		StringBuffer sql = new StringBuffer();
		sql.append("select pro_no, pro_name, pro_price " + "from test_product where pro_no = ?");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product_VO vo = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, pro_no);
			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new Product_VO();
				vo.setPro_no(rs.getString(1));
				vo.setPro_name(rs.getString(2));
				vo.setPro_price(rs.getInt(3));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	// ����
	public Product_VO edit_product(Product_VO pvo) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("update test_product " + "set pro_name=?, pro_price=? " + "where pro_no=?");

		Connection con = null;
		PreparedStatement ps = null;
		Product_VO vo = pvo;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());

			ps.setString(1, vo.getPro_name());
			ps.setInt(2, vo.getPro_price());
			ps.setString(3, vo.getPro_no());

			int i = ps.executeUpdate();

			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("��ǰ����");
				alert.setHeaderText("'" + vo.getPro_name() + "' ��ǰ������ �Ϸ�ƽ��ϴ�.");
				alert.setContentText("��ǰ������ �����Ǿ����ϴ�. ���� ���۽�, ����� ������ �����˴ϴ�.");
				alert.showAndWait();
			}
		} catch (SQLException e) {
			System.out.println("SQL�� ����:" + e);
		} catch (Exception e) {
			System.out.println("����:" + e);
		} finally {
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
		return pvo;
	}
}