package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import model.Input_emp_VO;
import model.Product_VO;
import model.Sales_VO;

public class Main_DAO {

	// �Ǹ��߰�
	public Sales_VO is_input_p(Sales_VO s_vo) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into test_sales2" + " values (?,?,?,?,?,?,?,?,?,?)");

		// 3���������غ�
		Connection con = null;
		PreparedStatement ps = null;
		Sales_VO vo = s_vo;

		try {
			// 1.������� DButilŬ������ ����޼ҵ� ���� �ҷ���
			con = DButil.connec();
			// 2.ps�� con ����
			ps = con.prepareStatement(sql.toString());
			// 3.ps�� SQL�� ������
			ps.setString(1, vo.getE_no());
			ps.setString(2, vo.getSt_no());
			ps.setInt(3, vo.getAc_sales_num());
			ps.setInt(4, vo.getAc_sales_price());
			ps.setString(5, vo.getMemo());
			ps.setString(6, vo.getSales_time());
			ps.setString(7, vo.getPro_no());
			ps.setInt(8, vo.getPro_price());
			ps.setInt(9, vo.getPro_num());
			ps.setString(10, vo.getSales_date());

			// 4.SQL�� ���� �� ó�� ���Ȯ��
			int i = ps.executeUpdate(); // update���� �����ϸ� 1�� ����

			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("�ǸŽ��� ���");
				alert.setHeaderText(vo.getE_no() + "���� �ǸŽ����� ��� �Ǿ����ϴ�.");
				alert.setContentText("*^^�Ǹ����ּż� �����մϴ�^^*");
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
		return s_vo;
	}

	// ����Ǿ��ִ� ���������ҷ����� (vo�� �޾Ƽ� vo�� ��ȯ)
	public Sales_VO get_ac_num_price(String e_no) {
		// max��ã��
		StringBuffer sql = new StringBuffer();
		sql.append("select MAX(ac_sales_num),MAX(AC_SALES_PRICE) from TEST_SALES2 where E_NO = ?");

		Connection con = null;
		PreparedStatement ps = null;
		Sales_VO vo = null;
		ResultSet rs = null;
		try {
			// ����
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, e_no);
			// rs ������ ����� ������
			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new Sales_VO(rs.getInt(1), rs.getInt(2));
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
		return vo;
	}

	// �����ͺ��̽����� Į������
	// ArrayList�� �ް� ������(��ȯ��)�� String
	public ArrayList<String> get_Column_num(String e_no) {
		ArrayList<String> num = new ArrayList<String>();

		StringBuffer sql = new StringBuffer();
		sql.append("select SALES_TIME,pro_no,pro_num,pro_price,AC_SALES_NUM,AC_SALES_PRICE,MEMO,SALES_DATE"
				+ " from TEST_SALES2 where E_NO = ?");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sales_VO vo = null;
		// resultSetMetaData ��������
		ResultSetMetaData rsmd = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, e_no);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();

			// Į������
			int col = rsmd.getColumnCount(); // Į��ī���� ������ col�� ����

			for (int i = 1; i <= col; i++) {
				num.add(rsmd.getColumnName(i)); // Į���̸��߰�??
			}

		} catch (SQLException e) {
			System.err.println("SQL������1=" + e);
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

	// �Ǹ� ��ü����Ʈ
	// ArrayList�� �ް� ������(��ȯ��)�� voŬ����
	public ArrayList<Sales_VO> get_sales(String e_no) {
		ArrayList<Sales_VO> list = new ArrayList<Sales_VO>();

		StringBuffer sql = new StringBuffer();
		sql.append("select SALES_TIME,pro_no,pro_num,pro_price,AC_SALES_NUM,AC_SALES_PRICE,MEMO,SALES_DATE"
				+ " from TEST_SALES2 where E_NO = ? order by AC_SALES_price");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sales_VO vo = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, e_no);
			rs = ps.executeQuery();

			// 7����Į��
			while (rs.next()) {
				vo = new Sales_VO();
				vo.setSales_time(rs.getString(1));
				vo.setPro_no(rs.getString(2));
				vo.setPro_num(rs.getInt(3));
				vo.setPro_price(rs.getInt(4));
				vo.setAc_sales_num(rs.getInt(5));
				vo.setAc_sales_price(rs.getInt(6));
				vo.setMemo(rs.getString(7));
				vo.setSales_date(rs.getString(8).substring(0, 10));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
				// TODO: handle exception
			}
		}
		return list;
	}

	// ��ȸ�˻� - ��¥
	public ObservableList<Sales_VO> get_select_date(String date, String e_no) throws Exception {
		ObservableList<Sales_VO> list = FXCollections.observableArrayList();
		StringBuffer sql = new StringBuffer();
		sql.append("select SALES_TIME,pro_no,pro_num,pro_price,AC_SALES_NUM,AC_SALES_PRICE,MEMO, SALES_DATE "
				+ "from TEST_SALES2 where SALES_DATE = ? and e_no = ? order by AC_SALES_NUM");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sales_VO vo = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, date);
			ps.setString(2, e_no);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new Sales_VO();
				vo.setSales_time(rs.getString(1));
				vo.setPro_no(rs.getString(2));
				vo.setPro_num(rs.getInt(3));
				vo.setPro_price(rs.getInt(4));
				vo.setAc_sales_num(rs.getInt(5));
				vo.setAc_sales_price(rs.getInt(6));
				vo.setMemo(rs.getString(7));
				vo.setSales_date(rs.getString(8));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// ��ȸ�˻� - ��ǰ�ڵ��ȣ
	public ObservableList<Sales_VO> get_select(String pro_no, String e_no) throws Exception {
		ObservableList<Sales_VO> list = FXCollections.observableArrayList();
		StringBuffer sql = new StringBuffer();
		sql.append("select SALES_TIME,pro_no,pro_num,pro_price,AC_SALES_NUM,AC_SALES_PRICE,MEMO,SALES_DATE "
				+ "from TEST_SALES2 where pro_no like ? and e_no = ? order by AC_SALES_NUM");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sales_VO vo = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, "%" + pro_no + "%");
			ps.setString(2, e_no);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new Sales_VO();
				vo.setSales_time(rs.getString(1));
				vo.setPro_no(rs.getString(2));
				vo.setPro_num(rs.getInt(3));
				vo.setPro_price(rs.getInt(4));
				vo.setAc_sales_num(rs.getInt(5));
				vo.setAc_sales_price(rs.getInt(6));
				vo.setMemo(rs.getString(7));
				vo.setSales_date(rs.getString(8));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// ��ȸ�˻� - �޸�
	public ObservableList<Sales_VO> get_select_memo(String memo, String e_no) throws Exception {
		ObservableList<Sales_VO> list = FXCollections.observableArrayList();
		StringBuffer sql = new StringBuffer();
		sql.append("select SALES_TIME,pro_no,pro_num,pro_price,AC_SALES_NUM,AC_SALES_PRICE,MEMO,SALES_DATE "
				+ "from TEST_SALES2 where memo like ? and e_no = ? order by AC_SALES_NUM");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sales_VO vo = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, "%" + memo + "%");
			ps.setString(2, e_no);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new Sales_VO();
				vo.setSales_time(rs.getString(1));
				vo.setPro_no(rs.getString(2));
				vo.setPro_num(rs.getInt(3));
				vo.setPro_price(rs.getInt(4));
				vo.setAc_sales_num(rs.getInt(5));
				vo.setAc_sales_price(rs.getInt(6));
				vo.setMemo(rs.getString(7));
				vo.setSales_date(rs.getString(8));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// �����޼ҵ�
	public void get_delete(int ac_num, String e_no) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from TEST_SALES2 where AC_SALES_NUM = ? and e_no =?");

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, ac_num);
			ps.setString(2, e_no);

			// �����
			int i = ps.executeUpdate();
			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("�ǸŽ������� ����");
				alert.setHeaderText("�ǸŽ������ ����");
				alert.setContentText("������ �ǸŽ��� ����� ��������Ǿ����ϴ�.");
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

	// ���������� ��ü����
	public void get_update_delect(int pro_num, int pro_price, String e_no, int ac_num) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("update test_sales2 set AC_SALES_NUM = AC_SALES_NUM-?, AC_SALES_PRICE = AC_SALES_PRICE-? "
				+ "where E_NO = ? and AC_SALES_NUM > ?");

		Connection con = null;
		PreparedStatement ps = null;
		Sales_VO vo = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, pro_num);
			ps.setInt(2, pro_price);
			ps.setString(3, e_no);
			ps.setInt(4, ac_num);

			int i = ps.executeUpdate();

			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("��������");
				alert.setHeaderText("�ǸŽ�������� ������ �Ϸ�ƽ��ϴ�.");
				alert.setContentText("�ǸŽ�������� �����ƽ��ϴ�. ���� ���۽�, ����� ������ �����˴ϴ�.");
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
	}

	// �ִ��ġ��������
	public int get_ac_num(String e_no) {
		StringBuffer sql = new StringBuffer();
		sql.append("select max(AC_SALES_NUM) from TEST_SALES2 where e_no = ?");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sales_VO vo = null;
		int a = 0;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, e_no);
			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new Sales_VO();
				vo.setAc_sales_num(rs.getInt(1));
				a = vo.getAc_sales_num();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;

	}

	// ������ ��ȸ (���� arraylist)
	public ArrayList<Input_emp_VO> get_im(String e_no) {
		ArrayList<Input_emp_VO> list = new ArrayList<Input_emp_VO>();

		StringBuffer sql = new StringBuffer();
		sql.append("select * from TEST_EMPLOYEE where E_NO = ?");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Input_emp_VO vo = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, e_no);
			rs = ps.executeQuery();

			// 7����Į��
			while (rs.next()) {
				vo = new Input_emp_VO();
				vo.setE_no(rs.getString(1));
				vo.setE_name(rs.getString(2));
				vo.setAge(rs.getString(3));
				vo.setPhone(rs.getString(4));
				vo.setSpot(rs.getString(5));
				vo.setPw(rs.getString(6));
				vo.setSt_no(rs.getString(7));
				vo.setMag(rs.getString(8));
				vo.setSal(rs.getInt(9));
				vo.setSales_date(rs.getString(10));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
				// TODO: handle exception
			}
		}
		return list;
	}

	// ������ ����
	// ������ �ȉ�!!!!!!!!
	public void get_im_edit(String e_name, String age, String phone, String spot, String pw, String mag, int sal,
			String e_no) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE TEST_EMPLOYEE set e_name = ?, age=?, PHONE = ?,"
				+ " SPOT = ? , pw = ? , MAG = ?, SAL = ? where e_no = ? ");

		Connection con = null;
		PreparedStatement ps = null;
		Input_emp_VO vo = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, e_name);
			ps.setString(2, age);
			ps.setString(3, phone);
			ps.setString(4, spot);
			ps.setString(5, pw);
			ps.setString(6, mag);
			ps.setInt(7, sal);
			ps.setString(8, e_no);

			int i = ps.executeUpdate();

			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("��������");
				alert.setHeaderText("'" + e_name + "'���� ���������� �Ϸ�ƽ��ϴ�.");
				alert.setContentText("���� ������ �����ƽ��ϴ�. ���� ���۽�, ����� ������ �����˴ϴ�.");
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
	}

	// ���������޼ҵ�
	// �����ڵ庯��� ��������
	public void get_im_delete(String e_no) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from TEST_EMPLOYEE where e_no =?");

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, e_no);

			// �����
			int i = ps.executeUpdate();

			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("�������� ����");
				alert.setHeaderText("���������� �Ϸ�Ǿ����ϴ�.");
				alert.setContentText("�׵��� �����ϼ̽��ϴ�^^��");
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

	// ���������޼ҵ�
	// �����ڵ庯��� ��������(����)
	public void get_sales_delete(String e_no) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from TEST_SALES2 where e_no = ?");

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, e_no);

			// �����
			int i = ps.executeUpdate();

			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("�������� ����");
				alert.setHeaderText("�ǸŽ��������� �Ϸ�Ǿ����ϴ�.");
				alert.setContentText("�׵��� �����ϼ̽��ϴ�^^��");

				// Ok�� ������
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					Platform.exit();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

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

	// ����
	public void get_commit() throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("commit");

		// 3���������غ�
		Connection con = null;
		PreparedStatement ps = null;

		try {
			// 1.������� DButilŬ������ ����޼ҵ� ���� �ҷ���
			con = DButil.connec();
			// 2.ps�� con ����
			ps = con.prepareStatement(sql.toString());

			// 4.SQL�� ���� �� ó�� ���Ȯ��
			int i = ps.executeUpdate(); // update���� �����ϸ� 1�� ����

			if (i == 1) {
				System.out.println("�����Ϸ�");
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

	}

}
