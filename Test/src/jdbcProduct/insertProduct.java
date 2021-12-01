package jdbcProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			//1단계 계정연결
			conn = DB.getConnection();
			sql = "insert into product values(?,?,?,?)";
			
			//sql문 데이터 삽입 및 실행
			//상품명 product , 개수 num , 가격 price , 상태 컨디션
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"전자레인지");
			pstmt.setInt(2,2);
			pstmt.setInt(3,100000);
			pstmt.setString(4,"중");
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 완료");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(pstmt!=null)try{pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try{conn.close();}catch(SQLException e) {}
		}
	}

}
