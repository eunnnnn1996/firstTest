package kr.s08.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.s03.preparedstatement.DBUtill;

//DAO �����ͺ��̽��� �����͸� ���������� ȣ���ϰ� �����ϴ� ��ü

public class ScoreDAO {
	
	public void insertInfo(ScoreVO score) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "insert into score (num,name,korean,english,math,sum,avg,grade,reg_date)"
					+ "values(score_seq.nextval,?,?,?,?,?,?,?,SYSDATE)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, score.getName());
			pstmt.setInt(2, score.getKorean());
			pstmt.setInt(3, score.getEnglish());
			pstmt.setInt(4, score.getMath());
			pstmt.setInt(5, score.makeSum());
			pstmt.setInt(6, score.makeAvg());
			pstmt.setString(7, score.makeGrade());
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "�� ���� �߰� �߽��ϴ�.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(null, pstmt, conn);
		}
	}
	
	public void selectListInfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtill.getConnection();
			sql = "select * from score order by num desc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			System.out.println("���ڷ�� : " + getCountInfo());
			System.out.println("---------------------------------------");
			System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���");
			System.out.println("--------------------------------------");
			
			while(rs.next()) {
				System.out.print(rs.getInt("num")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getInt("korean")+"\t");
				System.out.print(rs.getInt("english")+"\t");
				System.out.print(rs.getInt("math")+"\t");
				System.out.print(rs.getInt("sum")+"\t");
				System.out.print(rs.getInt("avg")+"\t");
				System.out.println(rs.getString("grade")+"\t");
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}
	
	//���ڵ� �� ����
	public int getCountInfo() {
		int count =0;
		return count;
	}
	
	public void selectDetailInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "select * from score where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("��ȣ : " + rs.getInt("num"));
				System.out.println("�̸� : " + rs.getString("name"));
				System.out.println("���� : " + rs.getInt("korean"));
				System.out.println("���� : " + rs.getInt("english"));
				System.out.println("���� : " + rs.getInt("math"));
				System.out.println("���� : " + rs.getInt("sum"));
				System.out.println("��� : " + rs.getInt("avg"));
				System.out.println("��� : " + rs.getString("grade"));
				System.out.println("�Է��� : " + rs.getString("reg_date"));
			}else {
				System.out.println("�˻��� ������ �����ϴ�.");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}
	
	public void updateInfo(ScoreVO score) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "update score set name=?,korean=?,english=?,math=?,sum=?,avg=?,grade=?"
					+ "where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, score.getName());
			pstmt.setInt(2, score.getKorean());
			pstmt.setInt(3, score.getEnglish());
			pstmt.setInt(4, score.getMath());
			pstmt.setInt(5, score.makeSum());
			pstmt.setInt(6, score.makeAvg());
			pstmt.setString(7, score.makeGrade());
			pstmt.setInt(8, score.getNum());
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "�� ���� ���� �߽��ϴ�.");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(null, pstmt, conn);
		}
	}
	
	public void deleteInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "delete from score where num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			int count = pstmt.executeUpdate();
			System.out.println(count +"���� ����");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(null, pstmt, conn);
		}
	}
}
