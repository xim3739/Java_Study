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

	// 판매추가
	public Sales_VO is_input_p(Sales_VO s_vo) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into test_sales2" + " values (?,?,?,?,?,?,?,?,?,?)");

		// 3가지연동준비
		Connection con = null;
		PreparedStatement ps = null;
		Sales_VO vo = s_vo;

		try {
			// 1.연결먼저 DButil클래스에 연결메소드 먼저 불러옴
			con = DButil.connec();
			// 2.ps랑 con 연동
			ps = con.prepareStatement(sql.toString());
			// 3.ps에 SQL문 보내기
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

			// 4.SQL문 수행 후 처리 결과확인
			int i = ps.executeUpdate(); // update문이 성공하면 1을 보냄

			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("판매실적 등록");
				alert.setHeaderText(vo.getE_no() + "님의 판매실적이 등록 되었습니다.");
				alert.setContentText("*^^판매해주셔서 감사합니다^^*");
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
		return s_vo;
	}

	// 저장되어있는 누적개수불러오기 (vo로 받아서 vo로 반환)
	public Sales_VO get_ac_num_price(String e_no) {
		// max로찾기
		StringBuffer sql = new StringBuffer();
		sql.append("select MAX(ac_sales_num),MAX(AC_SALES_PRICE) from TEST_SALES2 where E_NO = ?");

		Connection con = null;
		PreparedStatement ps = null;
		Sales_VO vo = null;
		ResultSet rs = null;
		try {
			// 연결
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, e_no);
			// rs 값으로 결과값 보내기
			rs = ps.executeQuery();

			if (rs.next()) {
				vo = new Sales_VO(rs.getInt(1), rs.getInt(2));
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
		return vo;
	}

	// 데이터베이스에서 칼럼개수
	// ArrayList로 받고 참조형(반환형)이 String
	public ArrayList<String> get_Column_num(String e_no) {
		ArrayList<String> num = new ArrayList<String>();

		StringBuffer sql = new StringBuffer();
		sql.append("select SALES_TIME,pro_no,pro_num,pro_price,AC_SALES_NUM,AC_SALES_PRICE,MEMO,SALES_DATE"
				+ " from TEST_SALES2 where E_NO = ?");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sales_VO vo = null;
		// resultSetMetaData 변수선언
		ResultSetMetaData rsmd = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, e_no);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();

			// 칼럼개수
			int col = rsmd.getColumnCount(); // 칼럼카운터 개수를 col에 넣음

			for (int i = 1; i <= col; i++) {
				num.add(rsmd.getColumnName(i)); // 칼럼이름추가??
			}

		} catch (SQLException e) {
			System.err.println("SQL문오류1=" + e);
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

	// 판매 전체리스트
	// ArrayList로 받고 참조형(반환형)이 vo클래스
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

			// 7개의칼럼
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

	// 조회검색 - 날짜
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

	// 조회검색 - 상품코드번호
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

	// 조회검색 - 메모
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

	// 삭제메소드
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

			// 결과값
			int i = ps.executeUpdate();
			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("판매실적삭제 성공");
				alert.setHeaderText("판매실적기록 삭제");
				alert.setContentText("선택한 판매실적 기록은 정상삭제되었습니다.");
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

	// 삭제나오면 전체수정
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
				alert.setTitle("실적수정");
				alert.setHeaderText("판매실적기록이 수정이 완료됐습니다.");
				alert.setContentText("판매실적기록이 수정됐습니다. 새로 시작시, 변경된 값으로 수정됩니다.");
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
	}

	// 최대수치가져오기
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

	// 내정보 조회 (직원 arraylist)
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

			// 7개의칼럼
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

	// 내정보 수정
	// 수정문 안됌!!!!!!!!
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
				alert.setTitle("직원수정");
				alert.setHeaderText("'" + e_name + "'님의 직원수정이 완료됐습니다.");
				alert.setContentText("직원 정보가 수정됐습니다. 새로 시작시, 변경된 값으로 수정됩니다.");
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
	}

	// 직원삭제메소드
	// 매장코드변경시 직원삭제
	public void get_im_delete(String e_no) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from TEST_EMPLOYEE where e_no =?");

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, e_no);

			// 결과값
			int i = ps.executeUpdate();

			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("직원삭제 성공");
				alert.setHeaderText("직원삭제가 완료되었습니다.");
				alert.setContentText("그동안 수고하셨습니다^^♥");
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

	// 직원삭제메소드
	// 매장코드변경시 직원삭제(실적)
	public void get_sales_delete(String e_no) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from TEST_SALES2 where e_no = ?");

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DButil.connec();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, e_no);

			// 결과값
			int i = ps.executeUpdate();

			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("실적삭제 성공");
				alert.setHeaderText("판매실적삭제가 완료되었습니다.");
				alert.setContentText("그동안 수고하셨습니다^^♥");

				// Ok를 누를때
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

	// 종료
	public void get_commit() throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("commit");

		// 3가지연동준비
		Connection con = null;
		PreparedStatement ps = null;

		try {
			// 1.연결먼저 DButil클래스에 연결메소드 먼저 불러옴
			con = DButil.connec();
			// 2.ps랑 con 연동
			ps = con.prepareStatement(sql.toString());

			// 4.SQL문 수행 후 처리 결과확인
			int i = ps.executeUpdate(); // update문이 성공하면 1을 보냄

			if (i == 1) {
				System.out.println("마감완료");
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

	}

}
