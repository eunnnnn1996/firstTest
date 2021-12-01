package kr.s04.preparedstatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.s03.preparedstatement.DBUtill;

public class InsertMemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("메모를 입력합니다.");
			System.out.print("제목>");
			String title = br.readLine();
			System.out.print("이름>");
			String name = br.readLine();
			System.out.print("메모>");
			String memo =br.readLine();
			System.out.print("이메일>");
			String email =br.readLine();
			
			//JDBC 수행 1,2단계
			conn = DBUtill.getConnection();
			//JDBC 수행 3단계 : PreparedStatement 객체 생성								//시퀀스 의미??
			sql = "INSERT INTO test2 (num, title,name,memo,email,reg_date) "
					+ "VALUES(test2_seq.nextval,?,?,?,?,SYSDATE)";
						//이클립스에서 지원해주는 문장 연결 
			
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, memo);
			pstmt.setString(4, email);
			

			//JDBC 수행 4단계 : SQL문을 실행해서 테이블에 행을 추가
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행의 정보를 추가했습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(null, pstmt, conn);
			if(br!=null)try {br.close();}catch(Exception e) {} //입력 하는 것으로 생략가능
		}
	}

}



































