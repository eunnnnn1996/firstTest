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
			//1�ܰ�, 2�ܰ� ����
			conn = DBUtill.getConnection();
			sql = "delete from test1 where id=?";			
			//3�ܰ� preparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql); // prepareStatement ���·� ���� �� �� ���·� ���
			//?�� ������ ����
			pstmt.setString(1, "star");
			//4�ܰ� sql�� �����ؼ� ���̺��� ������ ����
			int count = pstmt.executeUpdate();
			System.out.println(count + "�� ���� ������ �����߽��ϴ�.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}
}
