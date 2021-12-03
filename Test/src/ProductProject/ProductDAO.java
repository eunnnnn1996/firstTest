package ProductProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbcProduct.DB;

public class ProductDAO {
//물건 등록하기 , 물건 정보보기 , 물건 목록보기 , 삭제 , 수정
//	/name,  price , count , condition
	public void InsertProduct(String proname , int price , int count , String condition) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DB.getConnection();
			
			sql = "insert into PRODUCT values(product_seq.nextval,?,?,?,?,SYSDATE)";
														//nextval - 시퀀스값 증가
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, proname);
			pstmt.setInt(2, price);
			pstmt.setInt(3, count);
			pstmt.setString(4, condition);
			
			int up = pstmt.executeUpdate();
			System.out.println(up + "개행 추가");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DB.executeClose(null,pstmt, conn);
		}
	}
	
	
	
	
	//////////////////////삭제
	public void DeleteProduct(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DB.getConnection();
			sql = "delete from PRODUCT where num = ?";
			
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			int up = pstmt.executeUpdate();
			System.out.println(up + "개행 삭제");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DB.executeClose(null, pstmt, conn);
		}
	}
	
	
	/////////////////////물건 보기
	
	public void SelectProduct() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DB.getConnection();
			sql = "select * from PRODUCT order by num desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("num"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DB.executeClose(rs, pstmt, conn);
		}	
	}
	
	
	
	/////////////수정
	public void UpdateProduct(String proname , int price , int count , String condition, int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DB.getConnection();
			sql = "update PRODUCT set proname = ? , price = ? , count = ? , condition = ?  where num =?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,proname);
			pstmt.setInt(2,price);
			pstmt.setInt(3,count);
			pstmt.setString(4,condition);
			pstmt.setInt(5,num);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DB.executeClose(null, conn);
		}
	}
	
}



































