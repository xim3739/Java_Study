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
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
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
		} finally {
			try {
				// ⑥ 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
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
		} finally {
			try {
				// ⑥ 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
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
	
}
