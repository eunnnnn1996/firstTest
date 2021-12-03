package ProductProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbcProduct.DB;

public class ProductDAO {
//���� ����ϱ� , ���� �������� , ���� ��Ϻ��� , ���� , ����
//	/name,  price , count , condition
	public void InsertProduct(String proname , int price , int count , String condition) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DB.getConnection();
			
			sql = "insert into PRODUCT values(product_seq.nextval,?,?,?,?,SYSDATE)";
														//nextval - �������� ����
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, proname);
			pstmt.setInt(2, price);
			pstmt.setInt(3, count);
			pstmt.setString(4, condition);
			
			int up = pstmt.executeUpdate();
			System.out.println(up + "���� �߰�");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DB.executeClose(null,pstmt, conn);
		}
	}
	
	
	
	
	//////////////////////����
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
			System.out.println(up + "���� ����");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DB.executeClose(null, pstmt, conn);
		}
	}
	
	
	/////////////////////���� ����
	
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
	
	
	
	/////////////����
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



































