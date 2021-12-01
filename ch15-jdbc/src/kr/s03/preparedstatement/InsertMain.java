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
			//jdbc ���� 1,2 �ܰ�
			conn = DBUtill.getConnection();
			sql = "INSERT INTO test1 VALUES(?,?)"; // '?'�� �ڸ��� ��� ����, �ؿ��� ���� ������ �Է�
			//jdbc ���� 3�ܰ� preparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, "star");            // 1���� star�� sql���� ����ǥ�� ����ȴ�
			pstmt.setInt(2, 50);					// 2���� 50�� sql���� ����ǥ�� ����ȴ�
			
			
			//jdbc ���� 4�ܰ� sql���� �����ؼ� ���̺� ���� �߰�
			int count = pstmt.executeUpdate();
			System.out.println(count + "�� ���� �߰� �߽��ϴ�.");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}

}
