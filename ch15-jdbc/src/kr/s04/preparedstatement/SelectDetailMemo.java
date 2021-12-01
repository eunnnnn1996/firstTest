package kr.s04.preparedstatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.s03.preparedstatement.DBUtill;

public class SelectDetailMemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("�޸� ���������� ��ȸ�մϴ�.");
			System.out.println("�޸� ��ȣ>");
			int num = Integer.parseInt(br.readLine());
			
			conn = DBUtill.getConnection();
			
			sql = "select * from test2 where num = ?";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(rs, pstmt, conn);
			if(br!=null)try {br.close();}catch(Exception e) {}
		}
	}

}
