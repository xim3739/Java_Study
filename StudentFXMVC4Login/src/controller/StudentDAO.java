package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.StudentVO;

public class StudentDAO {
	
	// ① 신규 학생 점수 등록
	public int getStudentregiste(StudentVO svo) throws Exception {
		// ② 데이터 처리를 위한 SQL 문
		// 해당된 필드 no부분은 자동으로 증가되므로 필드를 줄 필요가 없음.
		String dml = "insert into schoolchild "
				+ "(name, year, ban, gender, korean, english, math, sic, soc, music, total, avg, register, filename)" + " values "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?)";

		Connection con = null;
		PreparedStatement pstmt = null;
		StudentVO retval = null;
		int i = 0;

		try {
			// ③ DBUtil 클래스의 getConnection( )메서드로 데이터베이스와 연결
			con = DBUtil.getConnection();

			// ④ 입력받은 학생 정보를 처리하기 위하여 SQL문장을 생성
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, svo.getName());
			pstmt.setString(2, svo.getLevel());
			pstmt.setString(3, svo.getBan());
			pstmt.setString(4, svo.getGender());
			pstmt.setInt(5, svo.getKorean());
			pstmt.setInt(6, svo.getEnglish());
			pstmt.setInt(7, svo.getMath());
			pstmt.setInt(8, svo.getSic());
			pstmt.setInt(9, svo.getSoc());
			pstmt.setInt(10, svo.getMusic());
			pstmt.setInt(11, svo.getTotal());
			pstmt.setDouble(12, svo.getAvg());
			pstmt.setString(13, svo.getFilename());

			// ⑤ SQL문을 수행후 처리 결과를 얻어옴
			i = pstmt.executeUpdate();

			retval = new StudentVO();

		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// ⑥ 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return i;
	}

	// ⑦ 학생의 name을 입력받아 정보 조회
	public ArrayList<StudentVO> getStudentCheck(String name) throws Exception {
		String dml = "select * from schoolchild where name like ?";
		ArrayList<StudentVO> arrayList = new ArrayList<StudentVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO retval = null;
		String name2 = "%" + name + "%";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, name2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				retval = new StudentVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),
						rs.getInt(12), rs.getDouble(13), rs.getString(14), rs.getString(15));
				arrayList.add(retval);
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
		return arrayList;
	}

	// 선택한 학생의 점수 수정
	public StudentVO getStudentUpdate(StudentVO svo, int no) throws Exception {
		// ② 데이터 처리를 위한 SQL 문
		String dml = "update schoolchild set "
				+ " korean=?, english=?, math=?, sic=?, soc=?, music=?, total=?, avg=?  where no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		StudentVO retval = null;

		try {
			// ③ DBUtil이라는 클래스의 getConnection( )메서드로 데이터베이스와 연결
			con = DBUtil.getConnection();

			// ④ 수정한 학생 정보를 수정하기 위하여 SQL문장을 생성
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, svo.getKorean());
			pstmt.setInt(2, svo.getEnglish());
			pstmt.setInt(3, svo.getMath());
			pstmt.setInt(4, svo.getSic());
			pstmt.setInt(5, svo.getSoc());
			pstmt.setInt(6, svo.getMusic());
			pstmt.setInt(7, svo.getTotal());
			pstmt.setDouble(8, svo.getAvg());
			pstmt.setDouble(9, no);

			// ⑤ SQL문을 수행후 처리 결과를 얻어옴
			int i = pstmt.executeUpdate();

			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("점수 수정");
				alert.setHeaderText("점수 수정 완료.");
				alert.setContentText("점수 수정 성공!!!");

				alert.showAndWait();
				retval = new StudentVO();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("점수 수정");
				alert.setHeaderText("점수 수정 실패.");
				alert.setContentText("점수 수정 실패!!!");

				alert.showAndWait();
			}

		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// ⑥ 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return retval;
	}

	public void getStudentDelete(int no) throws Exception {
		// ② 데이터 처리를 위한 SQL 문
		String dml = "delete from schoolchild where no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// ③ DBUtil이라는 클래스의 getConnection( )메서드로 데이터베이스와 연결
			con = DBUtil.getConnection();

			// ⑤ SQL문을 수행후 처리 결과를 얻어옴
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, no);

			// ⑤ SQL문을 수행후 처리 결과를 얻어옴
			int i = pstmt.executeUpdate();

			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("학생 삭제");
				alert.setHeaderText("학생 삭제 완료.");
				alert.setContentText("학생 삭제 성공!!!");

				alert.showAndWait();

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("학생 삭제");
				alert.setHeaderText("학생 삭제 실패.");
				alert.setContentText("학생 삭제 실패!!!");

				alert.showAndWait();
			}

		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// ⑥ 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

	}
	// 학생 전체 리스트
	public ArrayList<StudentVO> getStudentTotal() {
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		String dml = "select * from schoolchild";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 디비에서 가져온 데이터를 임시로 저장하고 있는 공간
		StudentVO studentVo = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				studentVo = new StudentVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11),
						rs.getInt(12), rs.getDouble(13), rs.getString(14), rs.getString(15));
				list.add(studentVo);
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
		return list;
	}

	// 데이터베이스에서 학생 테이블의 컬럼의 갯수
	public ArrayList<String> getColumnName() {
		ArrayList<String> columnName = new ArrayList<String>();

		String sql = "select * from schoolchild";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// ResultSetMetaData 객체 변수 선언
		ResultSetMetaData rsmd = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			for (int i = 1; i <= cols; i++) {
				columnName.add(rsmd.getColumnName(i));
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
		return columnName;
	}
	
}