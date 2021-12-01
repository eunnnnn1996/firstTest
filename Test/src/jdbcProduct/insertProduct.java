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
			//1�ܰ� ��������
			conn = DB.getConnection();
			sql = "insert into product values(?,?,?,?)";
			
			//sql�� ������ ���� �� ����
			//��ǰ�� product , ���� num , ���� price , ���� �����
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"���ڷ�����");
			pstmt.setInt(2,2);
			pstmt.setInt(3,100000);
			pstmt.setString(4,"��");
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "�� �Ϸ�");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(pstmt!=null)try{pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try{conn.close();}catch(SQLException e) {}
		}
	}

}
