package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Login_VO;

public class Login_DAO {

	// 아이디 비밀번호 등록 메소드
	public Login_VO login_input(Login_VO loginvo) throws Exception {
		// 1.VO를 꼭 반환형으로 받아오는거 잊지말자

		// 2.SQL문 작성
		StringBuffer sql = new StringBuffer(); // String 대신 StringBuffer사용
		sql.append("insert into test_login (id, pw) " + "values (?, ?)");

		// 3.3가지의 연동(con,ps,rs-resultSet대신 VO문(데이터값 들어가있는 list)으로 대체)
		Connection con = null;
		PreparedStatement ps = null;
		Login_VO lvo = loginvo; //null값이 아닌 매개변수로 받았던 걸 넣는다.
		
		//안전을 위해 try-catch문 사용
		try {
			//DButil 클래스의 연결메소드로 연결먼저
			con = DButil.connec();
			
			//preparedStatement con과 연결시킴
			ps = con.prepareStatement(sql.toString());
			
			//preparedStatements에 SQL문 생성
			ps.setString(1, lvo.getId()); //ps.set반환형(몇번째,VO클래스 변수.get가져올 항목)
			ps.setString(2, lvo.getPw());
			
			//SQL문 수행 후 처리 결과
			int i = ps.executeUpdate(); //update문이 성공하면 1을 보냄
			
			if (i == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("추가");
				alert.setHeaderText("추가성공");
				alert.setContentText("SQL developer가서 확인해보시요");

				alert.showAndWait();

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("추가");
				alert.setHeaderText("추가실패");
				alert.setContentText("문제점찾으시오");

				alert.showAndWait();
			}
		
		} catch (SQLException e) {
			// SQL문 오류
			System.err.println("SQL문 오류 "+e);
		} catch (Exception e) {
			// 그외 다른 오류
			System.err.println("오류 "+e);
		} finally {
			try {
				//선입후출형식으로 닫는다.
				if (ps != null) // 연결이 됐으면 (null값이 아닐때) 닫는다.
					ps.close();
				if (con != null) // 연결이 됐으면 (null값이 아닐때) 닫는다.
					con.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return loginvo;
	}
}
