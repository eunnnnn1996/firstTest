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
			//1�ܰ�, 2�ܰ� ����
			conn = DBUtill.getConnection();
			
			sql = "UPDATE test1 SET age=? where id = ?";
			
			//3�ܰ� preparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			//?�� ������ ����
			pstmt.setInt(1, 19); //ù��° ����ǥ�� 19 ����
			pstmt.setString(2, "star"); // �ι�° ����ǥ�� star ����
			
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
