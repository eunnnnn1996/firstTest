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
			//JDBC ���� 2�ܰ� : Connection ��ü ����(ID,��й�ȣ ����)
			conn = DriverManager.getConnection(db_url,db_id,db_password);
			//JDBC ���� 3�ܰ� : Statement ��ü ����
			stmt = conn.createStatement();
			
			//SQL�� �ۼ�
			sql = "drop table test1";
			
			//JDBC ���� 4�ܰ� : SQL���� �����ؼ� ���̺�κ��� ���ڵ�(��)�� ���޹޾Ƽ�
			//                ��������� ����� ResultSet ��ü�� ��Ƽ� ��ȯ
			stmt.executeQuery(sql);
			System.out.println("���̺� ����");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//�ڿ�����
			if(stmt!=null)try {stmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
	}

}
