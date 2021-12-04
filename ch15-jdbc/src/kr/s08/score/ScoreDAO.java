package kr.s08.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.s03.preparedstatement.DBUtill;

//DAO 데이터베이스의 데이터를 전문적으로 호출하고 제어하는 객체

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
			System.out.println(count + "개 행을 추가 했습니다.");
			
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
			
			System.out.println("총자료수 : " + getCountInfo());
			System.out.println("---------------------------------------");
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등급");
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
	
	//레코드 총 개수
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
				System.out.println("번호 : " + rs.getInt("num"));
				System.out.println("이름 : " + rs.getString("name"));
				System.out.println("국어 : " + rs.getInt("korean"));
				System.out.println("영어 : " + rs.getInt("english"));
				System.out.println("수학 : " + rs.getInt("math"));
				System.out.println("총점 : " + rs.getInt("sum"));
				System.out.println("평균 : " + rs.getInt("avg"));
				System.out.println("등급 : " + rs.getString("grade"));
				System.out.println("입력일 : " + rs.getString("reg_date"));
			}else {
				System.out.println("검색된 내용이 없습니다.");
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
			System.out.println(count + "개 행을 수정 했습니다.");
			
			
			
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
			System.out.println(count +"개행 삭제");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(null, pstmt, conn);
		}
	}
}
