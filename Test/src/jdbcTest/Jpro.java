package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jpro {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //내 db 주소
		//String sql = "select * from emp";
		String sql = "select * from emp where sal > 1500";
		// ex) 급여가 1500초과인 직원만 검색
		// ex) 조회수가 100이상인 게시글만 검색
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"scott","tiger");
													//url ,db계정, db비밀번호
		Statement st = con.createStatement();
		// Connection으로 연결한 객체에게, Query 작업을 실행하기 위한 객체
		ResultSet rs = st.executeQuery(sql); //sql 실행!!
		
		while(rs.next()) { //rs.next()로 sql을 가져온다
			System.out.print(rs.getString("ename"));
			System.out.print("\t");
			System.out.println(rs.getInt("sal"));
		}
		
		rs.close();
		st.close();
		con.close();
		
	}

}
