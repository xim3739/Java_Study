package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.AlertMessage;
import util.DBUtil;

public class GoodsDAO {

	public void insertGoodsDB(GoodsVO goodsVO) {

		String dml = "insert into goodsTBL (goods, price) values (?,?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, goodsVO.getGoods());
			pstmt.setInt(2, goodsVO.getPrice());

			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "품목을 저장하는 도중 에러가 발생했습니다.");
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
		
	} // end of insertGoodsDB
	
	public ArrayList<GoodsVO> getGoodsTotal() {
		
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		
		String dml = "select * from goodsTBL";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GoodsVO goodsVO = null;
		
		try {
			
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				goodsVO = new GoodsVO(rs.getString(1), rs.getInt(2));
				list.add(goodsVO);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "품목을 불러오는 도중 에러가 발생했습니다.");
			
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
		
		return list;
		
	} // end of getGoodsTotal
	
	public int deleteGoods(String goods) throws Exception {
		
		String dml = "delete from goodsTBL where goods = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;
		
		try {
			
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, goods);
			
			i = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "품목을 지우는 도중 에러가 발생했습니다.");
		} finally {
			try {
				// ⑥ 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "데이터 베이스 접속 중 에러가 발생했습니다.");
			}
		}
		
		return i;

	} // end of deleteGoods
	
	public void updateGoods(GoodsVO goodsVO, String goods, int price) {
		
		String dml = "update goodsTBL set goods = ?, price = ? where goods = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		GoodsVO returnGoodsVO = null;
		
		try {
			
			con = DBUtil.getConnection();
		
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, goods);
			pstmt.setInt(2, price);
			pstmt.setString(3, goodsVO.getGoods());
			
			int check = pstmt.executeUpdate();
			
			if(check == 1) {
				AlertMessage.alertWarningDisplay(1, "Edit Sucess", "Edit Sucess", "Edit Sucess");
			} else {
				AlertMessage.alertWarningDisplay(1, "Edit Failed", "Edit Failed", "Edit Failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "품목을 업데이트 하는 도중 에러가 발생했습니다.");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "데이터 베이스 연결 도중 에러가 발생했습니다.");
				
			}
		}
		
		return;
		
	}
	
public void updateOnlyPrice(GoodsVO goodsVO, int price) {
		
		String dml = "update goodsTBL set price = ? where goods = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		GoodsVO returnGoodsVO = null;
		
		try {
			
			con = DBUtil.getConnection();
		
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, price);
			pstmt.setString(2, goodsVO.getGoods());
			
			int check = pstmt.executeUpdate();
			
			if(check == 1) {
				AlertMessage.alertWarningDisplay(1, "Edit Sucess", "Edit Sucess", "Edit Sucess");
			} else {
				AlertMessage.alertWarningDisplay(1, "Edit Failed", "Edit Failed", "Edit Failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "품목을 업데이트 하는 도중 에러가 발생했습니다.");
		} finally {
			try {
				// ⑥ 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "데이터 베이스 연결 도중 에러가 발생했습니다.");
			}
		}
		
		return;
		
	}
	
	public ObservableList<GoodsVO> getCheckGoods(String goods) throws Exception {
		
		String dml = "select * from goodsTBL where goods like ?";
		ObservableList<GoodsVO> list = FXCollections.observableArrayList();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GoodsVO returnGoods = null;
		String likeGoods = "%" + goods + "%";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, likeGoods);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				returnGoods = new GoodsVO(rs.getString(1), rs.getInt(2));
				list.add(returnGoods);
			}
		} catch (Exception e) {
			e.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "품목을 체크하는 도중 에러가 발생했습니다.");
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
		return list;
	}
	
}
