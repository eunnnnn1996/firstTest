package kr.s03.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//1단계, 2단계 수행
			conn = DBUtill.getConnection();
			
			sql = "UPDATE test1 SET age=? where id = ?";
			
			//3단계 preparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 삽입
			pstmt.setInt(1, 19); //첫번째 물음표에 19 저장
			pstmt.setString(2, "star"); // 두번째 물음표에 star 저장
			
			//4단계 sql문 실행해서 테이블의 데이터 수정
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행의 정보를 수정했습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}

}
