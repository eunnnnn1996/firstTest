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
			//1�ܰ� ��������
			br = new BufferedReader(new InputStreamReader(System.in));
			conn = DB.getConnection();
			sql = "insert into product values(?,?,?,?)";
			
			//sql�� ������ ���� �� ����
			//��ǰ�� product , ���� num , ���� price , ���� �����
			
			
			pstmt = conn.prepareStatement(sql);
			
			
			System.out.println("��ǰ��>");
			String pro = br.readLine();
			pstmt.setString(1,pro);
			
			
			System.out.println("����>");
			int num = Integer.parseInt(br.readLine());
			pstmt.setInt(2,num);
			
			
			System.out.println("����>");
			int pri = Integer.parseInt(br.readLine());
			pstmt.setInt(3,pri);
			
			
			System.out.println("����>");
			String condi = br.readLine();
			pstmt.setString(4,condi);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "�� �Ϸ�");
			
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
