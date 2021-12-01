package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//1단계, 2단계 수행
			conn = DBUtill.getConnection();
			sql = "delete from test1 where id=?";			
			//3단계 preparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql); // prepareStatement 형태로 많이 씀 이 형태로 기억
			//?에 데이터 삽입
			pstmt.setString(1, "star");
			//4단계 sql문 실행해서 테이블의 데이터 수정
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행의 정보를 삭제했습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}
}
