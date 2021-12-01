package jdbcProduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class createProductTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id = "scott";
		String db_password = "tiger"; 
		
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		
		try {
			Class.forName(db_driver);
			conn = DriverManager.getConnection(db_url,db_id,db_password);
			stmt = conn.createStatement();
			
			sql = "create table Product (product varchar2(30),"
					+ "num number,"
					+ "price number,"
					+ "condition varchar(60))";
			stmt.executeUpdate(sql);
			System.out.println("¿Ï·á");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}

}
