package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jpro {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //�� db �ּ�
		//String sql = "select * from emp";
		String sql = "select * from emp where sal > 1500";
		// ex) �޿��� 1500�ʰ��� ������ �˻�
		// ex) ��ȸ���� 100�̻��� �Խñ۸� �˻�
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"scott","tiger");
													//url ,db����, db��й�ȣ
		Statement st = con.createStatement();
		// Connection���� ������ ��ü����, Query �۾��� �����ϱ� ���� ��ü
		ResultSet rs = st.executeQuery(sql); //sql ����!!
		
		while(rs.next()) { //rs.next()�� sql�� �����´�
			System.out.print(rs.getString("ename"));
			System.out.print("\t");
			System.out.println(rs.getInt("sal"));
		}
		
		rs.close();
		st.close();
		con.close();
		
	}

}
