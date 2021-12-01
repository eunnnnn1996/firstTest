package kr.s04.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.s03.preparedstatement.DBUtill;

public class SelectListMemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			// 1,2�ܰ�
			conn = DBUtill.getConnection();
			sql = "select * from test2 order by num desc";
			// 3�ܰ�
			pstmt = conn.prepareStatement(sql);
			// 4�ܰ�
			rs = pstmt.executeQuery();
			System.out.println("��ȣ\t����\t�ۼ���\t�ۼ���");
			System.out.println("----------------------------------");

			while (rs.next()) {
				System.out.print(rs.getInt("num") + "\t");
				System.out.print(rs.getString("title") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.println(rs.getDate("reg_date") + "\t");
				//�̸����̶� �޸�� ���������� ���� �� �� �ֵ��� ����
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}

	}

}
