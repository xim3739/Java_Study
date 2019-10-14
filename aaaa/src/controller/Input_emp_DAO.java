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

	// 직원 등록 메소드
	public Optional<ButtonType> input_e(Input_emp_VO ie_vo) throws Exception {
		// 스트링버퍼 인스턴스
		StringBuffer sql = new StringBuffer();
		// append이용 하여SQL문 작성
		sql.append("insert into test_employee " + "values (?,?,?,?,?,?,?,?,?,?)"); // 10개
																					// 칼럼
		Optional<ButtonType> result = null;
		// 3가지연동준비
		Connection con = null;
		PreparedStatement ps = null;
		Input_emp_VO vo = ie_vo;

		try {
			// 1.연결먼저 DButil클래스에 연결메소드 먼저 불러옴
			con = DButil.connec();
			// 2.ps랑 con 연동
			ps = con.prepareStatement(sql.toString());
			// 3.ps에 SQL문 보내기
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

			// 4.SQL문 수행 후 처리 결과확인
			int i = ps.executeUpdate(); // update문이 성공하면 1을 보냄

			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("직원등록");
				alert.setHeaderText(vo.getE_name() + "님의 사원등록 되었습니다.");
				alert.setContentText("innisfree 00123매장 사원등록완료 \n ok버튼 클릭시, 로그인창으로 넘어갑니다.");
				// Ok를 누를때
				result = alert.showAndWait();

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("추가");
				alert.setHeaderText("추가실패");
				alert.setContentText("문제점찾으시오");

				alert.showAndWait();
			}

		} catch (SQLException e) {
			System.err.println("SQL문 오류:" + e);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("실패");
			alert.setHeaderText("추가실패");
			alert.setContentText("확인 후 다시 가입하시오.");

			alert.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("연결오류" + e);
		} finally {
			try {
				// 연동한 순서대로 선입후출 닫기
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

	// 직급에 따라 사원번호 비번 값 다 가져오기
	public ArrayList<Input_emp_VO> get_enoPw(String spot) throws Exception {
		// 리스트생성
		ArrayList<Input_emp_VO> list = new ArrayList<Input_emp_VO>();
		// SQL문
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
			rs = ps.executeQuery(); // 쿼리문을 rs로 보내겠다.

			while (rs.next()) { // 다음이 있으면 계속 반복
				vo = new Input_emp_VO(); // 인스턴스
				vo.setE_no(rs.getString("e_no"));
				vo.setPw(rs.getString("pw"));
				list.add(vo);
			}
		} catch (SQLException e) {
			System.err.println("SQL문 오류" + e);
		} catch (Exception e) {
			System.err.println("연결 오류" + e);
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

	// 지위에 따른 id를 가져오고,id와 텍스트 필드가 일치한지 (return 이름을 반환한다.)
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
			// 연결
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());

			// ?값에 다 보내기
			ps.setString(1, vo.getE_name());
			ps.setString(2, spot);

			// rs 값으로 결과값 보내기
			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new Input_emp_VO(); // 인스턴스
				vo.setE_name(rs.getString(1));
				a = vo.getE_name();
			}

		} catch (SQLException e) {
			System.err.println("SQL문오류" + e);
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

			}
		}
		return a;
	}

	// 지위에 따른 id를 가져오고,id와 텍스트 필드가 일치한지 (return 이름을 반환한다.)
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
			// 연결
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());

			// ?값에 다 보내기
			ps.setString(1, vo.getE_name());
			ps.setString(2, spot);

			// rs 값으로 결과값 보내기
			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new Input_emp_VO(); // 인스턴스
				vo.setE_name(rs.getString(1));
				a = vo.getE_name();
			}

		} catch (SQLException e) {
			System.err.println("SQL문오류" + e);
		} catch (Exception e) {
			System.err.println("오류" + e);
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

	// 아이디
	public String get_id_eNo2(Input_emp_VO ie_vo) {
		StringBuffer sql = new StringBuffer();
		sql.append("select e_name from TEST_EMPLOYEE where e_no= ? ");

		Connection con = null;
		PreparedStatement ps = null;
		Input_emp_VO vo = ie_vo;
		ResultSet rs = null;
		String a = null;

		try {
			// 연결
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());

			// ?값에 다 보내기
			ps.setString(1, vo.getE_name());

			// rs 값으로 결과값 보내기
			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new Input_emp_VO(); // 인스턴스
				vo.setE_name(rs.getString(1));
				a = vo.getE_name();
			}

		} catch (SQLException e) {
			System.err.println("SQL문오류" + e);
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

			}
		}
		return a;
	}

	// 지위에 따른 id를 가져오고,id와 텍스트 필드가 일치한지 (return 이름을 반환한다.)
	public String get_pw2(Input_emp_VO ie_vo) {
		StringBuffer sql = new StringBuffer();
		sql.append("select e_name from TEST_EMPLOYEE where pw = ? ");

		Connection con = null;
		PreparedStatement ps = null;
		Input_emp_VO vo = ie_vo;
		ResultSet rs = null;
		String a = null;

		try {
			// 연결
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());

			// ?값에 다 보내기
			ps.setString(1, vo.getE_name());

			// rs 값으로 결과값 보내기
			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new Input_emp_VO(); // 인스턴스
				vo.setE_name(rs.getString(1));
				a = vo.getE_name();
			}

		} catch (SQLException e) {
			System.err.println("SQL문오류" + e);
		} catch (Exception e) {
			System.err.println("오류" + e);
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

	// 중복회원 막기
	public ArrayList<Input_emp_VO> get_uniq_enoPw() throws Exception {
		// 리스트생성
		ArrayList<Input_emp_VO> list = new ArrayList<Input_emp_VO>();
		// SQL문
		StringBuffer sql = new StringBuffer();
		sql.append("select e_no, pw from TEST_EMPLOYEE");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Input_emp_VO vo = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());

			rs = ps.executeQuery(); // 쿼리문을 rs로 보내겠다.

			while (rs.next()) { // 다음이 있으면 계속 반복
				vo = new Input_emp_VO(); // 인스턴스
				vo.setE_no(rs.getString("e_no"));
				vo.setPw(rs.getString("pw"));
				list.add(vo);
			}
		} catch (SQLException e) {
			System.err.println("SQL문 오류" + e);
		} catch (Exception e) {
			System.err.println("연결 오류" + e);
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

	// 사번 찾기
	public String get_select_eNo (Input_emp_VO ie_vo) {
		StringBuffer sql = new StringBuffer();
		sql.append("select e_no from TEST_EMPLOYEE where e_name = ? and  age = ? and phone = ?");

		Connection con = null;
		PreparedStatement ps = null;
		Input_emp_VO vo = ie_vo;
		ResultSet rs = null;
		String a = null;

		try {
			// 연결
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());

			// ?값에 다 보내기
			ps.setString(1, vo.getE_name());
			ps.setString(2, vo.getAge());
			ps.setString(3, vo.getPhone());

			// rs 값으로 결과값 보내기
			rs = ps.executeQuery();

			if (rs.next()) {
				a = rs.getString(1);
			}

		} catch (SQLException e) {
			System.err.println("SQL문오류" + e);
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

			}
		}
		return a;
	}
	
	// 비번 찾기
	public String get_select_pw (Input_emp_VO ie_vo) {
			StringBuffer sql = new StringBuffer();
			sql.append("select pw from TEST_EMPLOYEE where e_name = ? and  age = ? and phone = ?");

			Connection con = null;
			PreparedStatement ps = null;
			Input_emp_VO vo = ie_vo;
			ResultSet rs = null;
			String a = null;

			try {
				// 연결
				con = DButil.connec();
				ps = con.prepareStatement(sql.toString());

				// ?값에 다 보내기
				ps.setString(1, vo.getE_name());
				ps.setString(2, vo.getAge());
				ps.setString(3, vo.getPhone());

				// rs 값으로 결과값 보내기
				rs = ps.executeQuery();

				if (rs.next()) {
					a = rs.getString(1);
				}

			} catch (SQLException e) {
				System.err.println("SQL문오류" + e);
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

				}
			}
			return a;
		}
}
