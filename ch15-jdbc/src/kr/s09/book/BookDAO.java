package kr.s09.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.s03.preparedstatement.DBUtill;

public class BookDAO {
	// 도서 등록

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

	// 도서 목록 보기
	public void selectListBook() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DBUtill.getConnection();
			sql = "select bk_num,bk_name,bk_category,bk_regdate,re_status from book "
					+ "left outer join (select * from reservation where re_status=1) "
					+ "using(bk_num) order by bk_num desc";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			System.out.println("----------------------------------------");
			System.out.println("번호\t분류\t등록일\t\t대출여부\t도서명");
			System.out.println("----------------------------------------");
			while (rs.next()) {
				System.out.print(rs.getInt("bk_num") + "\t");
				System.out.print(rs.getString("bk_category") + "\t");
				System.out.print(rs.getDate("bk_regdate") + "\t");
				if (rs.getInt("re_status") == 0) { // re_status는 null값 INT로 변환 시 0으로 반환
					System.out.print("대출 가능\t");
				} else {
					System.out.print("대출 중\t");
				}
				System.out.println(rs.getString("bk_name"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}
	//대출등록
	public void insertReservation(ReservationVO reservation) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "insert into reservation (re_num,bk_num,me_num,re_status) " //re_num 대출번호 
																			  //bk_num 책번호
																			  //me_num 내번호
					+ "values(reservation_seq.nextval,?,?,1)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reservation.getBk_num());
			pstmt.setInt(2, reservation.getMe_num());
			
			int count = pstmt.executeUpdate();
			System.out.println(count +"개 행을 추가했습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(null, pstmt, conn);
		}
	}
	//대출 여부 확인
	
	public int getStatusReservation(int bk_num) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = null;
	      int count = 0;
	      
	      try {
	         //JDBC 수행 1,2단계
	         conn = DBUtill.getConnection();
	         //SQL문 작성
	         sql = "SELECT re_status FROM book LEFT OUTER JOIN " //left outer join 잘못 입력한 값 찾기
	               + "(SELECT * FROM reservation WHERE re_status=1) USING(bk_num) WHERE bk_num=?";
	         //JDBC 수행 3단계 : PreparedStatement 객체 생성
	         pstmt = conn.prepareStatement(sql);
	         //?에 데이터 바인딩   
	         pstmt.setInt(1, bk_num);
	         //JDBC 수행 4단계 : SQL문을 실행해서 테이블로부터 대출여부 조회
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	                     //컬럼 인덱스
	            count = rs.getInt(1);//도서 번호가 있을 때
	         }else{
	            count = -1;//도서 번호가 없을 때
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         //자원정리
	         DBUtill.executeClose(rs, pstmt, conn);
	      }
	      
	      return count;
	   }
	
	public void updateReservation(int re_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "update reservation set re_status=0, re_modifydate=SYSDATE where re_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re_num);
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 행을 수정 했습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(null, pstmt, conn);
		}
	}
	
	//대출 목록 보기
	public void selectListReservation() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "select re_num, me_id,me_name,bk_name,re_status,re_regdate,re_modifydate from reservation "
					+ "join book using(bk_num) join member using(me_num) "
					+ "order by re_num desc";
			
			pstmt = conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			System.out.println("-------------------------------");
			System.out.println("번호\t아이디\t대출자\t대출도서명\t대출여부\t대출일\t반납일");
			System.out.println("-------------------------------");
			
			while(rs.next()) {
				System.out.print(rs.getInt("re_num")+"\t");
				System.out.print(rs.getString("me_id")+"\t");
				System.out.print(rs.getString("me_name")+"\t");
				System.out.print(rs.getString("bk_name")+"\t");
				if(rs.getInt("re_status")==0) {
					System.out.print("반납\t");
				}else {
					System.out.print("대출 중\t");
				}
				System.out.print(rs.getDate("re_regdate")+"\t");
				if(rs.getDate("re_modifydate") == null) {
					System.out.println("");
				}else {
					System.out.println(rs.getDate("re_modifydate"));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}
	//MY대출 목록 보기
	public void selectMyList(int me_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "select re_num, me_id,me_name,bk_name,re_status,re_regdate,re_modifydate from reservation "
					+ "join book using(bk_num) join member using(me_num) "
					+ "where me_num=? order by re_num desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, me_num);
			rs= pstmt.executeQuery();
		    
			System.out.println("-------------------------------");
			System.out.println("번호\t아이디\t대출자\t대출도서명\t대출여부\t대출일\t반납일");
			System.out.println("-------------------------------");
			
			while(rs.next()) {
				System.out.print(rs.getInt("re_num")+"\t");
				System.out.print(rs.getString("me_id")+"\t");
				System.out.print(rs.getString("me_name")+"\t");
				System.out.print(rs.getString("bk_name")+"\t");
				if(rs.getInt("re_status")==0) {
					System.out.print("반납\t");
				}else {
					System.out.print("대출 중\t");
				}
				System.out.print(rs.getDate("re_regdate")+"\t");
				if(rs.getDate("re_modifydate") == null) {
					System.out.println("");
				}else {
					System.out.println(rs.getDate("re_modifydate"));
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}
	
	// 회원가입
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
		} finally {
			DBUtill.executeClose(null, pstmt, conn);
		}
	}

	// 회원목록
	public void selectListMember() {
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

			while (rs.next()) {
				System.out.print(rs.getInt("me_num") + "\t");
				System.out.print(rs.getString("me_id") + "\t");
				System.out.print(rs.getString("me_name") + "\t");
				System.out.print(rs.getString("me_passwd") + "\t");
				System.out.print(rs.getString("me_phone") + "\t");
				System.out.println(rs.getDate("me_regdate"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}

	}

	// 아이디 중복체크
	public int checkId(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;

		try {
			conn = DBUtill.getConnection();
			sql = "select me_id from member where me_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, me_id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = 1; // 카운트가 0이면 아이디가 미존재, me_id가 없으면 if문에 진입하지 못함
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}

		return count;
	}

	public int loginCheck(String me_id, String me_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int me_num = 0;

		try {
			conn = DBUtill.getConnection();

			sql = "select me_num from member where me_id=? and me_passwd=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);

			rs = pstmt.executeQuery();
			if (rs.next()) { // 맴버id는 유니크키 이기때문에 행 하나만 불러와서 if로 명시 (while 대신)
				me_num = rs.getInt(1); // 인덱스 번호 명시, 행을 명시해도 가능
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}

		return me_num;
	}

	public int getStatusBack(int re_num, int me_num) {
		// TODO Auto-generated method stub
		return 0;
	}
}
