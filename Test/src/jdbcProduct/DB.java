package jdbcProduct;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	private static final String db_DRIVER = "oracle.jdbc.OracleDriver";
	private static final String db_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String db_ID = "scott";
	private static final String db_PASSWORD = "tiger";
	//db 연결 주소 , 계정정보
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(db_DRIVER); // 오라클 드라이버 연결
		
		return DriverManager.getConnection(db_URL,db_ID,db_PASSWORD); //오라클 url,계정연결 
	}
	
	//자원 정리
	public static void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
								//resultset 결과값 저장
								//preparedStatment sql 실행
		if(rs!=null)try{rs.close();}catch(SQLException e) {}
		if(pstmt!=null)try{rs.close();}catch(SQLException e) {}
		if(conn!=null)try{rs.close();}catch(SQLException e) {}
	}
	public static void executeClose(CallableStatement cstmt, Connection conn) {
		if(cstmt!=null)try {cstmt.close();}catch(SQLException e) {}
		if(conn!=null)try {conn.close();}catch(SQLException e) {}
	}
}













































