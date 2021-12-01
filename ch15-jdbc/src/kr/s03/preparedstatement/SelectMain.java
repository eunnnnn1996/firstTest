package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "select * from test1";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			System.out.println("ID\t³ªÀÌ");
			
			while(rs.next()) {
				System.out.print(rs.getString("id")+"\t");
				System.out.println(rs.getInt("age"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}

}
