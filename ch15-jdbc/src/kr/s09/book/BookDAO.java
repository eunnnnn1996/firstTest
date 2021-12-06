package kr.s09.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.s03.preparedstatement.DBUtill;

public class BookDAO {
	//도서 등록
	
	public void insertBook(BookVO book) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "insert into book (bk_num,bk_name,bk_category) values (book_seq.nextval,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBk_name());
			pstmt.setString(2, book.getBk_category());
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행을 추가 했습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(null, pstmt, conn);
		}
	}
	//도서 목록 보기
	public void selectListBook() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "select * from book order by bk_num desc";
			pstmt = conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			System.out.println("----------------------------------------");
			System.out.println("번호\t도서명\t\t분류\t등록일");
			System.out.println("----------------------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt("bk_num")+"\t");
				System.out.print(rs.getString("bk_name")+"\t");
				System.out.print(rs.getString("bk_category")+"\t");
				System.out.println(rs.getDate("bk_regdate"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}
	
	//회원가입 
	public void insertMember(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "insert into member (me_num,me_id,me_passwd,me_name,me_phone) "
					+ "values (member_seq.nextval,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMe_id());
			pstmt.setString(2, member.getMe_passwd());
			pstmt.setString(3, member.getMe_name());
			pstmt.setString(4, member.getMe_phone());
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행을 추가했습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(null,pstmt, conn);
		}
	}
	//회원목록
	public void selectListMember(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			
			sql = "select * from member order by me_num desc";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			System.out.println("--------------------------");
			System.out.println("번호\t아이디\t이름\t비밀번호\t전화번호\t가입일");
			
			while(rs.next()) {
				System.out.print(rs.getInt("me_num")+"\t");
				System.out.print(rs.getString("me_id")+"\t");
				System.out.print(rs.getString("me_name")+"\t");
				System.out.print(rs.getString("me_passwd")+"\t");
				System.out.print(rs.getString("me_phone")+"\t");
				System.out.println(rs.getDate("me_regdate"));
			}
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
		
		//로그인 체크
	} 	//로그인 체크 후 로그인이 가능하면 회원번호 반환
	public int loginCheck(String me_id, String me_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int me_num=0;
		
		try {
			conn = DBUtill.getConnection();
			
			sql = "select me_num from member where me_id=? and me_passwd=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);
			
			rs = pstmt.executeQuery();
			if(rs.next()) { //맴버id는 유니크키 이기때문에 행 하나만 불러와서 if로 명시 (while 대신)
				me_num = rs.getInt(1);  //인덱스 번호 명시, 행을 명시해도 가능
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
		
		return me_num;
	}
}










