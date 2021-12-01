package jdbcProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class selectProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DB.getConnection();
			sql = "select * from product";
			///////////////////////////////////
			pstmt = conn.prepareStatement(sql);
			///////////////////////////////////
			
			rs=pstmt.executeQuery(); // �� �о����
			System.out.println("��ǰ��\t����\t����\t����");
			while(rs.next()) {
				System.out.print(rs.getString("product")+"\t");
				System.out.print(rs.getInt("num")+"\t");
				System.out.print(rs.getInt("price")+"\t");
				System.out.println(rs.getString("condition"));	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DB.executeClose(rs, pstmt, conn);
		}
	}

}
