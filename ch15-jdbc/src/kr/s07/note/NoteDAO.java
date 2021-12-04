package kr.s07.note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.s03.preparedstatement.DBUtill;

public class NoteDAO {
	//DAO는 데이터베이스의 데이터를 전문적으로 호출하고 제어하는 객체
	
	//글쓰기 , 목록보기 , 상세글보기 , 글수정 , 글삭제 메소드 생성
	
	
	//글쓰기 메소드
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
			System.out.println(count+"개행 삽입 완료");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(null, pstmt,conn);
		}
	}
	
	//목록보기 메소드
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
			System.out.println("글번호\t제목\t이름\t작성일");
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
	
	//상세글보기
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
				System.out.println("글 번호 : "+rs.getInt("num"));
				System.out.println("이름 : "+rs.getString("name"));
				System.out.println("비밀번호 : "+rs.getString("passwd"));
				System.out.println("제목 : "+rs.getString("subject"));
				System.out.println("내용 : "+rs.getString("content"));
				System.out.println("이메일 : "+rs.getString("email"));
				System.out.println("작성일 : "+rs.getDate("reg_date"));
			}else {
				System.out.println("검색된 정보가 없습니다!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}
	
	//글 수정
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
			System.out.println(count + "개의 행을 수정했습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(null,pstmt, conn);
		}
	}
	
	//글 삭제
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
		System.out.println(count + "개의 행을 삭제했습니다.");
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		DBUtill.executeClose(null, pstmt,conn);
	}
	}
}
