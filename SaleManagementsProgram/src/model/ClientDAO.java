package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.AlertMessage;
import util.DBUtil;

public class ClientDAO {

	public void insertClientDB(ClientVO cvo) {

		String dml = "insert into clientdb " + "(id,password,name,phone)" + " values " + "(?,?,?,?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, cvo.getId());
			pstmt.setString(2, cvo.getPassword());
			pstmt.setString(3, cvo.getName());
			pstmt.setString(4, cvo.getPhone());

			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "회원 정보를 저장하는 도중 에러가 발생했습니다.");
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "데이터 베이스 접속 중 에러가 발생했습니다.");
			}

		}

	} // end of insertClientDB

	public ArrayList<ClientVO> getClientCheck(ClientVO cvo) throws Exception {

		String dml = "select * from clientdb where id = ?";

		ArrayList<ClientVO> clientList = new ArrayList<ClientVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ClientVO clientVo = null;
		String name2 = cvo.getId();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, name2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				clientVo = new ClientVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				clientList.add(clientVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "회원 ID 를 확인 하는 도중 에러가 발생했습니다.");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
				AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "데이터 베이스 접속 중 에러가 발생했습니다.");
			}
		}

		return clientList;

	} // end of getClientCheck

	public ArrayList<ClientVO> getClientInfo() {

		String dml = "select * from clientdb";
		ArrayList<ClientVO> clientList = new ArrayList<ClientVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClientVO clientVo = null;

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				clientVo = new ClientVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				clientList.add(clientVo);

			}

		} catch (SQLException e) {

			e.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "회원 정보를 불러오는 도중 에러가 발생했습니다.");

		} catch (Exception e) {

			e.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "데이터 베이스 접속 중 에러가 발생했습니다.");
			
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

		return clientList;

	}

}
