package kr.s04.preparedstatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.s03.preparedstatement.DBUtill;

public class UpdateMemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("�޸� �����մϴ�.");
			System.out.println("�޸� ��ȣ>");
			int num = Integer.parseInt(br.readLine());
			System.out.println("����");
			String title = br.readLine();
			System.out.println("�̸�");
			String name = br.readLine();
			System.out.println("�޸�");
			String memo = br.readLine();
			System.out.println("�̸���");
			String email = br.readLine();
			
			conn = DBUtill.getConnection();
			sql = "update test2 set title = ? , name = ? , memo = ? , email = ?  where num =?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, memo);
			pstmt.setString(4, email);
			pstmt.setInt(5, num);
			
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
