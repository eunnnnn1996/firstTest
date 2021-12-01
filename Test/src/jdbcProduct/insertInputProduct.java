package jdbcProduct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertInputProduct {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		BufferedReader br = null;
		
		
		
		try {
			//1단계 계정연결
			br = new BufferedReader(new InputStreamReader(System.in));
			conn = DB.getConnection();
			sql = "insert into product values(?,?,?,?)";
			
			//sql문 데이터 삽입 및 실행
			//상품명 product , 개수 num , 가격 price , 상태 컨디션
			
			
			pstmt = conn.prepareStatement(sql);
			
			
			System.out.println("제품명>");
			String pro = br.readLine();
			pstmt.setString(1,pro);
			
			
			System.out.println("개수>");
			int num = Integer.parseInt(br.readLine());
			pstmt.setInt(2,num);
			
			
			System.out.println("가격>");
			int pri = Integer.parseInt(br.readLine());
			pstmt.setInt(3,pri);
			
			
			System.out.println("상태>");
			String condi = br.readLine();
			pstmt.setString(4,condi);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 완료");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(pstmt!=null)try{pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try{conn.close();}catch(SQLException e) {}
			if(br!=null)try{br.close();}catch(Exception e) {}
		}
	}

}
