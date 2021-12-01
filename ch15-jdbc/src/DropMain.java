import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DropMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id = "scott";
		String db_password = "tiger";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			Class.forName(db_driver);
			//JDBC 수행 2단계 : Connection 객체 생성(ID,비밀번호 인증)
			conn = DriverManager.getConnection(db_url,db_id,db_password);
			//JDBC 수행 3단계 : Statement 객체 생성
			stmt = conn.createStatement();
			
			//SQL문 작성
			sql = "drop table test1";
			
			//JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 레코드(행)을 전달받아서
			//                결과집합을 만들고 ResultSet 객체에 담아서 반환
			stmt.executeQuery(sql);
			System.out.println("테이블 삭제");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//자원정리
			if(stmt!=null)try {stmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
	}

}
