package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//jdbc 수행 1,2 단계
			conn = DBUtill.getConnection();
			sql = "INSERT INTO test1 VALUES(?,?)"; // '?'는 자리만 잡는 역할, 밑에서 실제 데이터 입력
			//jdbc 수행 3단계 preparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, "star");            // 1열에 star가 sql변수 물음표에 저장된다
			pstmt.setInt(2, 50);					// 2열에 50이 sql변수 물음표에 저장된다
			
			
			//jdbc 수행 4단계 sql문을 실행해서 테이블에 행을 추가
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행을 추가 했습니다.");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}

}
