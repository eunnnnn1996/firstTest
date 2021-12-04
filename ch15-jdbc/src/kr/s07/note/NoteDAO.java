package kr.s07.note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.s03.preparedstatement.DBUtill;

public class NoteDAO {
	//DAO�� �����ͺ��̽��� �����͸� ���������� ȣ���ϰ� �����ϴ� ��ü
	
	//�۾��� , ��Ϻ��� , �󼼱ۺ��� , �ۼ��� , �ۻ��� �޼ҵ� ����
	
	
	//�۾��� �޼ҵ�
	public void insertInfo(String name, String passwd, String subject,
							String content , String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			
			sql = "insert into note values(note_seq.nextval,?,?,?,?,?,SYSDATE)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2,passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, email);
			
			int count = pstmt.executeUpdate();
			System.out.println(count+"���� ���� �Ϸ�");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(null, pstmt,conn);
		}
	}
	
	//��Ϻ��� �޼ҵ�
	public void selectListInfo() {
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			
			sql = "select * from note order by num desc";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			System.out.println("------------------------------");
			System.out.println("�۹�ȣ\t����\t�̸�\t�ۼ���");
			System.out.println("------------------------------");
			
			while(rs.next()) {
				System.out.print(rs.getInt("num") + "\t");
				System.out.print(rs.getString("subject")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.println(rs.getDate("reg_date")+"\t");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}
	
	//�󼼱ۺ���
	public void selectDetailInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		
		try {
			conn = DBUtill.getConnection();
			sql = "select * from note where num = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("�� ��ȣ : "+rs.getInt("num"));
				System.out.println("�̸� : "+rs.getString("name"));
				System.out.println("��й�ȣ : "+rs.getString("passwd"));
				System.out.println("���� : "+rs.getString("subject"));
				System.out.println("���� : "+rs.getString("content"));
				System.out.println("�̸��� : "+rs.getString("email"));
				System.out.println("�ۼ��� : "+rs.getDate("reg_date"));
			}else {
				System.out.println("�˻��� ������ �����ϴ�!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}
	
	//�� ����
	public void updateInfo(int num, String name, String passwd, String subject,
							String content, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "update note set name=?,passwd=?,subject=?,content=?,email=? where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, email);
			pstmt.setInt(6, num);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "���� ���� �����߽��ϴ�.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(null,pstmt, conn);
		}
	}
	
	//�� ����
	public void deleteInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
	try {
		conn = DBUtill.getConnection();
		sql = "delete from note where num=?";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, num);
		
		int count = pstmt.executeUpdate();
		System.out.println(count + "���� ���� �����߽��ϴ�.");
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		DBUtill.executeClose(null, pstmt,conn);
	}
	}
}
