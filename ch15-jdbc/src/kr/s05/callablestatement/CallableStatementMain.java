package kr.s05.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;

import kr.s03.preparedstatement.DBUtill;

public class CallableStatementMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		CallableStatement cstmt = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			
			sql = "{call adjust(?,?)}";
			/////////////////////////////////////
			//프로시저 호출
			/////////////////////////////////////
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, "SUNNY");
			cstmt.setFloat(2, 0.06f);
			
			cstmt.executeUpdate();
			System.out.println("급여 정보가 수정되었습니다.");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(cstmt, conn);
		}
	}

}
