package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import model.Input_emp_VO;

public class Input_emp_DAO {

	// ���� ��� �޼ҵ�
	public Optional<ButtonType> input_e(Input_emp_VO ie_vo) throws Exception {
		// ��Ʈ������ �ν��Ͻ�
		StringBuffer sql = new StringBuffer();
		// append�̿� �Ͽ�SQL�� �ۼ�
		sql.append("insert into test_employee " + "values (?,?,?,?,?,?,?,?,?,?)"); // 10��
																					// Į��
		Optional<ButtonType> result = null;
		// 3���������غ�
		Connection con = null;
		PreparedStatement ps = null;
		Input_emp_VO vo = ie_vo;

		try {
			// 1.������� DButilŬ������ ����޼ҵ� ���� �ҷ���
			con = DButil.connec();
			// 2.ps�� con ����
			ps = con.prepareStatement(sql.toString());
			// 3.ps�� SQL�� ������
			ps.setString(1, vo.getE_no());
			ps.setString(2, vo.getE_name());
			ps.setString(3, vo.getAge());
			ps.setString(4, vo.getPhone());
			ps.setString(5, vo.getSpot());
			ps.setString(6, vo.getPw());
			ps.setString(7, vo.getSt_no());
			ps.setString(8, vo.getMag());
			ps.setInt(9, vo.getSal());
			ps.setString(10, vo.getSales_date());

			// 4.SQL�� ���� �� ó�� ���Ȯ��
			int i = ps.executeUpdate(); // update���� �����ϸ� 1�� ����

			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("�������");
				alert.setHeaderText(vo.getE_name() + "���� ������ �Ǿ����ϴ�.");
				alert.setContentText("innisfree 00123���� �����ϿϷ� \n ok��ư Ŭ����, �α���â���� �Ѿ�ϴ�.");
				// Ok�� ������
				result = alert.showAndWait();

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("�߰�");
				alert.setHeaderText("�߰�����");
				alert.setContentText("������ã���ÿ�");

				alert.showAndWait();
			}

		} catch (SQLException e) {
			System.err.println("SQL�� ����:" + e);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("����");
			alert.setHeaderText("�߰�����");
			alert.setContentText("Ȯ�� �� �ٽ� �����Ͻÿ�.");

			alert.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("�������" + e);
		} finally {
			try {
				// ������ ������� �������� �ݱ�
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

		return result;
	}

	// ���޿� ���� �����ȣ ��� �� �� ��������
	public ArrayList<Input_emp_VO> get_enoPw(String spot) throws Exception {
		// ����Ʈ����
		ArrayList<Input_emp_VO> list = new ArrayList<Input_emp_VO>();
		// SQL��
		StringBuffer sql = new StringBuffer();
		sql.append("select e_no, pw from TEST_EMPLOYEE where spot = ?");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Input_emp_VO vo = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, spot);
			rs = ps.executeQuery(); // �������� rs�� �����ڴ�.

			while (rs.next()) { // ������ ������ ��� �ݺ�
				vo = new Input_emp_VO(); // �ν��Ͻ�
				vo.setE_no(rs.getString("e_no"));
				vo.setPw(rs.getString("pw"));
				list.add(vo);
			}
		} catch (SQLException e) {
			System.err.println("SQL�� ����" + e);
		} catch (Exception e) {
			System.err.println("���� ����" + e);
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

	// ������ ���� id�� ��������,id�� �ؽ�Ʈ �ʵ尡 ��ġ���� (return �̸��� ��ȯ�Ѵ�.)
	public String get_id_eNo(Input_emp_VO ie_vo, String spot) {
		StringBuffer sql = new StringBuffer();
		sql.append("select e_name from TEST_EMPLOYEE "
				+ "where e_no= ? and e_no in (select e_no from TEST_EMPLOYEE where spot = ?)");

		Connection con = null;
		PreparedStatement ps = null;
		Input_emp_VO vo = ie_vo;
		ResultSet rs = null;
		String a = null;

		try {
			// ����
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());

			// ?���� �� ������
			ps.setString(1, vo.getE_name());
			ps.setString(2, spot);

			// rs ������ ����� ������
			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new Input_emp_VO(); // �ν��Ͻ�
				vo.setE_name(rs.getString(1));
				a = vo.getE_name();
			}

		} catch (SQLException e) {
			System.err.println("SQL������" + e);
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

			}
		}
		return a;
	}

	// ������ ���� id�� ��������,id�� �ؽ�Ʈ �ʵ尡 ��ġ���� (return �̸��� ��ȯ�Ѵ�.)
	public String get_pw(Input_emp_VO ie_vo, String spot) {
		StringBuffer sql = new StringBuffer();
		sql.append("select e_name from TEST_EMPLOYEE "
				+ "where pw = ? and pw in (select pw from TEST_EMPLOYEE where spot = ?)");

		Connection con = null;
		PreparedStatement ps = null;
		Input_emp_VO vo = ie_vo;
		ResultSet rs = null;
		String a = null;

		try {
			// ����
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());

			// ?���� �� ������
			ps.setString(1, vo.getE_name());
			ps.setString(2, spot);

			// rs ������ ����� ������
			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new Input_emp_VO(); // �ν��Ͻ�
				vo.setE_name(rs.getString(1));
				a = vo.getE_name();
			}

		} catch (SQLException e) {
			System.err.println("SQL������" + e);
		} catch (Exception e) {
			System.err.println("����" + e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {

			}
		}
		return a;
	}

	// ���̵�
	public String get_id_eNo2(Input_emp_VO ie_vo) {
		StringBuffer sql = new StringBuffer();
		sql.append("select e_name from TEST_EMPLOYEE where e_no= ? ");

		Connection con = null;
		PreparedStatement ps = null;
		Input_emp_VO vo = ie_vo;
		ResultSet rs = null;
		String a = null;

		try {
			// ����
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());

			// ?���� �� ������
			ps.setString(1, vo.getE_name());

			// rs ������ ����� ������
			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new Input_emp_VO(); // �ν��Ͻ�
				vo.setE_name(rs.getString(1));
				a = vo.getE_name();
			}

		} catch (SQLException e) {
			System.err.println("SQL������" + e);
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

			}
		}
		return a;
	}

	// ������ ���� id�� ��������,id�� �ؽ�Ʈ �ʵ尡 ��ġ���� (return �̸��� ��ȯ�Ѵ�.)
	public String get_pw2(Input_emp_VO ie_vo) {
		StringBuffer sql = new StringBuffer();
		sql.append("select e_name from TEST_EMPLOYEE where pw = ? ");

		Connection con = null;
		PreparedStatement ps = null;
		Input_emp_VO vo = ie_vo;
		ResultSet rs = null;
		String a = null;

		try {
			// ����
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());

			// ?���� �� ������
			ps.setString(1, vo.getE_name());

			// rs ������ ����� ������
			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new Input_emp_VO(); // �ν��Ͻ�
				vo.setE_name(rs.getString(1));
				a = vo.getE_name();
			}

		} catch (SQLException e) {
			System.err.println("SQL������" + e);
		} catch (Exception e) {
			System.err.println("����" + e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {

			}
		}
		return a;
	}

	// �ߺ�ȸ�� ����
	public ArrayList<Input_emp_VO> get_uniq_enoPw() throws Exception {
		// ����Ʈ����
		ArrayList<Input_emp_VO> list = new ArrayList<Input_emp_VO>();
		// SQL��
		StringBuffer sql = new StringBuffer();
		sql.append("select e_no, pw from TEST_EMPLOYEE");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Input_emp_VO vo = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());

			rs = ps.executeQuery(); // �������� rs�� �����ڴ�.

			while (rs.next()) { // ������ ������ ��� �ݺ�
				vo = new Input_emp_VO(); // �ν��Ͻ�
				vo.setE_no(rs.getString("e_no"));
				vo.setPw(rs.getString("pw"));
				list.add(vo);
			}
		} catch (SQLException e) {
			System.err.println("SQL�� ����" + e);
		} catch (Exception e) {
			System.err.println("���� ����" + e);
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

	// ��� ã��
	public String get_select_eNo (Input_emp_VO ie_vo) {
		StringBuffer sql = new StringBuffer();
		sql.append("select e_no from TEST_EMPLOYEE where e_name = ? and  age = ? and phone = ?");

		Connection con = null;
		PreparedStatement ps = null;
		Input_emp_VO vo = ie_vo;
		ResultSet rs = null;
		String a = null;

		try {
			// ����
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());

			// ?���� �� ������
			ps.setString(1, vo.getE_name());
			ps.setString(2, vo.getAge());
			ps.setString(3, vo.getPhone());

			// rs ������ ����� ������
			rs = ps.executeQuery();

			if (rs.next()) {
				a = rs.getString(1);
			}

		} catch (SQLException e) {
			System.err.println("SQL������" + e);
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

			}
		}
		return a;
	}
	
	// ��� ã��
	public String get_select_pw (Input_emp_VO ie_vo) {
			StringBuffer sql = new StringBuffer();
			sql.append("select pw from TEST_EMPLOYEE where e_name = ? and  age = ? and phone = ?");

			Connection con = null;
			PreparedStatement ps = null;
			Input_emp_VO vo = ie_vo;
			ResultSet rs = null;
			String a = null;

			try {
				// ����
				con = DButil.connec();
				ps = con.prepareStatement(sql.toString());

				// ?���� �� ������
				ps.setString(1, vo.getE_name());
				ps.setString(2, vo.getAge());
				ps.setString(3, vo.getPhone());

				// rs ������ ����� ������
				rs = ps.executeQuery();

				if (rs.next()) {
					a = rs.getString(1);
				}

			} catch (SQLException e) {
				System.err.println("SQL������" + e);
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

				}
			}
			return a;
		}
}
