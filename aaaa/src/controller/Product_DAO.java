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

	// 상품입력메소드
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
				alert.setTitle("상품등록");
				alert.setHeaderText("'" + vo.getPro_name() + "' 상품등록이 되었습니다.");
				alert.setContentText("상품등록 성공");
				alert.showAndWait();
			}

		} catch (SQLException e) {
			System.out.println("SQL문 오류:" + e);

		} catch (Exception e) {
			System.out.println("SQL문 오류:" + e);
		} finally {
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
		return pvo;
	}

	// 상품코드번호 리스트 값 가져오기
	// ArrayList로 받고 참조형 vo클래스
	public ArrayList<Product_VO> get_list_proNo() {
		ArrayList<Product_VO> list = new ArrayList<Product_VO>();
		StringBuffer sql = new StringBuffer();
		sql.append("select pro_no from test_product"); // SQL문작성

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product_VO vo = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();

			// while문 사용하여 resultSet에 저장된 sql문 가져오기

			while (rs.next()) { // rs다음이 있냐없냐에 따라 반복함
				vo = new Product_VO();// 인스턴스
				vo.setPro_no(rs.getString(1)); // vo클래스에 설정한다. 설정값은 rs의 첫번째 인덱스
												// 값
				list.add(vo); // vo에 저장된 값을 list로 보낸다.
			}
		} catch (SQLException e) {
			System.err.println("SQL문 오류" + e);
		} catch (Exception e) {
			System.err.println("오류" + e);
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

	// 상품 전체리스트
	// ArrayList로 받고 참조형(반환형)이 vo클래스
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
			System.err.println("SQL문오류=" + e);
		} catch (Exception e) {
			System.err.println("오류=" + e);
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

	// 데이터베이스에서 상품테이블의 상품개수
	// ArrayList로 받고 참조형(반환형)이 String
	public ArrayList<String> get_Column_num() {
		ArrayList<String> num = new ArrayList<String>();

		StringBuffer sql = new StringBuffer();
		sql.append("select pro_no, pro_name, pro_price " + "from test_product");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product_VO vo = null;
		// resultSetMetaData 변수선언
		ResultSetMetaData rsmd = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();

			// 칼럼개수
			int col = rsmd.getColumnCount(); // 칼럼카운터 개수를 col에 넣음

			for (int i = 1; i <= col; i++) {
				num.add(rsmd.getColumnName(i)); // 칼럼이름추가??
			}
		} catch (SQLException e) {
			System.err.println("SQL문오류=" + e);
		} catch (Exception e) {
			System.err.println("오류=" + e);
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

	// 삭제메소드
	public void get_delete(String pro_no) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from test_product where pro_no = ?");

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, pro_no);

			// 결과값
			int i = ps.executeUpdate();
			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("상품삭제 성공");
				alert.setHeaderText("'"+pro_no+"' 상품삭제");
				alert.setContentText("선택한 상품은 정상삭제되었습니다.");
				alert.showAndWait();
			}

		} catch (SQLException e) {
			System.out.println("SQL오류:" + e);
		} catch (Exception e) {
			System.out.println("SQL오류:" + e);

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

	// 조회 검색
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

	// 수정
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
				alert.setTitle("상품수정");
				alert.setHeaderText("'" + vo.getPro_name() + "' 상품수정이 완료됐습니다.");
				alert.setContentText("상품수정이 성공되었습니다. 새로 시작시, 변경된 값으로 수정됩니다.");
				alert.showAndWait();
			}
		} catch (SQLException e) {
			System.out.println("SQL문 오류:" + e);
		} catch (Exception e) {
			System.out.println("오류:" + e);
		} finally {
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
		return pvo;
	}
}