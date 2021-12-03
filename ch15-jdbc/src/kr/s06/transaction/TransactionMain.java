package kr.s06.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.s03.preparedstatement.DBUtill;

public class TransactionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt1 = null; // preparedstatement�� �ϳ��� ���常 ���´�
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		String sql = null;

		try {
			conn = DBUtill.getConnection();

			// Ʈ����� ó���� ���ؼ� auto commit ����
			conn.setAutoCommit(false);

			sql = "insert into test1 values(?,?)"; // �ѹ���
			pstmt1 = conn.prepareStatement(sql); // �ѹ���
			pstmt1.setString(1, "Korea"); // �ѹ���
			pstmt1.setInt(2, 10); // �ѹ���
			pstmt1.executeUpdate(); // �ѹ���

			sql = "insert into test1 values(?,?)"; // �ѹ���
			pstmt2 = conn.prepareStatement(sql); // �ѹ���
			pstmt2.setString(1, "China"); // �ѹ���
			pstmt2.setInt(2, 20); // �ѹ���
			pstmt2.executeUpdate(); // �ѹ���

			// Ʈ����� �׽�Ʈ�� ���� sql���忡 ������ �߻���Ŵ
			sql = "insert into test1 values(?,?";
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.setString(1, "USA");
			pstmt3.setInt(2, 30);
			pstmt3.executeUpdate();

			conn.commit();
			System.out.println("�۾� �Ϸ�!!");

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
