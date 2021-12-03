package kr.s04.preparedstatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.s03.preparedstatement.DBUtill;

public class DeleteMemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("메모 정보를 삭제합니다.");
			System.out.println("메모 번호>");
			int num = Integer.parseInt(br.readLine());
			
			conn = DBUtill.getConnection();
			
			sql = "delete from test2 where num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행의 정보를 삭제했습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(null, pstmt, conn);
			if(br!=null)try {br.close();}catch(Exception e) {}
		}
	}

}
