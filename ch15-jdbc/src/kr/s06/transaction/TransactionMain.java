package kr.s06.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.s03.preparedstatement.DBUtill;

public class TransactionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt1 = null; // preparedstatement는 하나의 문장만 갖는다
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		String sql = null;

		try {
			conn = DBUtill.getConnection();

			// 트랜잭션 처리를 위해서 auto commit 해제
			conn.setAutoCommit(false);

			sql = "insert into test1 values(?,?)"; // 한묶음
			pstmt1 = conn.prepareStatement(sql); // 한묶음
			pstmt1.setString(1, "Korea"); // 한묶음
			pstmt1.setInt(2, 10); // 한묶음
			pstmt1.executeUpdate(); // 한묶음

			sql = "insert into test1 values(?,?)"; // 한묶음
			pstmt2 = conn.prepareStatement(sql); // 한묶음
			pstmt2.setString(1, "China"); // 한묶음
			pstmt2.setInt(2, 20); // 한묶음
			pstmt2.executeUpdate(); // 한묶음

			// 트랜잭션 테스트를 위해 sql문장에 오류를 발생시킴
			sql = "insert into test1 values(?,?";
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.setString(1, "USA");
			pstmt3.setInt(2, 30);
			pstmt3.executeUpdate();

			conn.commit();
			System.out.println("작업 완료!!");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		} finally {
			DBUtill.executeClose(null, pstmt1,null);
			DBUtill.executeClose(null, pstmt2,null);
			DBUtill.executeClose(null, pstmt3,null);
		}
	}

}
