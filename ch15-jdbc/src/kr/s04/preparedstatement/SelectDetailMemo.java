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
			System.out.println("메모 상세페이지를 조회합니다.");
			System.out.println("메모 번호>");
			int num = Integer.parseInt(br.readLine());
			
			conn = DBUtill.getConnection();
			
			sql = "select * from test2 where num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("번호 : "+ rs.getInt(num));
				System.out.println("제목 : "+ rs.getString("title"));
				System.out.println("작성자 : "+ rs.getString("name"));
				System.out.println("내용 : "+ rs.getString("memo"));
				System.out.println("이메일 : "+ rs.getString("email"));
				System.out.println("작성일 : "+ rs.getDate("reg_date"));
			}else {
				System.out.println("데이터 없음");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(rs, pstmt, conn);
			if(br!=null)try {br.close();}catch(Exception e) {}
		}
	}

}
